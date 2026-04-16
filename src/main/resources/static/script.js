// Global State
let currentQuestions = [];
let currentQuestionIndex = 0;
let score = 0;
let currentTopic = "";
let currentDifficulty = "easy"; // Default level

// View Navigation Logic
function switchView(viewId) {
    document.querySelectorAll('.view').forEach(view => {
        view.classList.remove('active');
    });
    document.getElementById(viewId).classList.add('active');
}

function showChaptersView() {
    switchView('chapters-view');
}

function goHome() {
    // Reset state when going home
    currentDifficulty = "easy";
    switchView('home-view');
}

// Start Quiz Logic
function startQuiz(topic) {
    currentTopic = topic;
    currentQuestionIndex = 0;
    score = 0;
    
    // Fetch questions from Spring Boot Backend
    fetch(`/api/questions?topic=${topic}&level=${currentDifficulty}`)
        .then(response => response.json())
        .then(data => {
            currentQuestions = data;
            if(currentQuestions.length > 0) {
                switchView('quiz-view');
                document.getElementById('quiz-title').innerText = `${topic} Quiz (${currentDifficulty})`;
                loadNextQuestion();
            } else {
                alert("No more questions found for this topic/level! You did all of them.");
            }
        })
        .catch(err => {
            console.error("Error fetching questions: ", err);
            alert("Could not connect to the backend. Make sure the Spring Boot server is running.");
        });
}

function retryQuiz() {
    // If they retry, upgrade difficulty to hard
    currentDifficulty = "hard"; // Level++ logic
    startQuiz(currentTopic);
}

// Question Rendering Logic
function loadNextQuestion() {
    document.getElementById('feedback-text').innerText = "";
    
    if (currentQuestionIndex >= currentQuestions.length) {
        showResult();
        return;
    }

    const q = currentQuestions[currentQuestionIndex];
    document.getElementById('current-q-num').innerText = currentQuestionIndex + 1;
    document.getElementById('question-text').innerText = q.text;

    const optionsContainer = document.getElementById('options-container');
    optionsContainer.innerHTML = ""; // Clear old options

    // Render 4 options using Array
    q.options.forEach((optText, i) => {
        const btn = document.createElement('button');
        btn.className = 'option-btn';
        btn.innerText = optText;
        btn.onclick = () => handleAnswer(i, btn, q.answerIndex);
        optionsContainer.appendChild(btn);
    });
}

// Score Calculation and Answer Logic
function handleAnswer(selectedIndex, btnElement, correctIndex) {
    // Disable all options so user can't click multiple times
    const allOptions = document.querySelectorAll('.option-btn');
    allOptions.forEach(btn => btn.disabled = true);

    const feedback = document.getElementById('feedback-text');

    if (selectedIndex === correctIndex) {
        btnElement.classList.add('correct');
        feedback.innerText = "Correct! ✅";
        feedback.style.color = "var(--success)";
        score++;
    } else {
        btnElement.classList.add('wrong');
        // Highlight correct one
        allOptions[correctIndex].classList.add('correct');
        feedback.innerText = "Wrong! ❌";
        feedback.style.color = "var(--error)";
    }

    // Go to next question after short delay
    setTimeout(() => {
        currentQuestionIndex++;
        loadNextQuestion();
    }, 1200);
}

// Results Logic
function showResult() {
    switchView('result-view');
    document.getElementById('final-score').innerText = score;
    
    const msg = document.getElementById('result-message');
    if(score >= 8) {
        msg.innerText = "Excellent Work! 🌟";
    } else if(score >= 5) {
        msg.innerText = "Good Job! Keep practicing. 👍";
    } else {
        msg.innerText = "Needs improvement. Try again! 💪";
    }
}
