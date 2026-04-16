package com.quiz.controller;

import com.quiz.model.Question;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*") // Allow frontend to call APIs without CORS issues
public class QuizController {

    private List<Question> questionBank;

    public QuizController() {
        questionBank = new ArrayList<>();
        loadQuestions();
    }

    // Load simple questions into a list (simulating a database)
    private void loadQuestions() {
        // ---- Java Questions ----
        // Easy Java
        questionBank.add(new Question("Which OOP concept hides internal details?", new String[]{"Inheritance", "Polymorphism", "Encapsulation", "Abstraction"}, 2, "Java", "easy"));
        questionBank.add(new Question("What translates Java bytecode to machine code?", new String[]{"JVM", "JIT", "JRE", "JDK"}, 1, "Java", "easy")); 
        questionBank.add(new Question("Which loop evaluates condition AFTER execution?", new String[]{"for", "while", "do-while", "foreach"}, 2, "Java", "easy"));
        questionBank.add(new Question("What is used to create an object in Java?", new String[]{"class", "new", "object", "create"}, 1, "Java", "easy"));
        questionBank.add(new Question("Arrays in Java are stored in?", new String[]{"Stack", "Heap", "Registers", "Meta-space"}, 1, "Java", "easy"));
        questionBank.add(new Question("Which String method is used to find its length?", new String[]{"size()", "length()", "len()", "count()"}, 1, "Java", "easy"));
        questionBank.add(new Question("Which block is always executed in exception handling?", new String[]{"try", "catch", "throws", "finally"}, 3, "Java", "easy"));
        questionBank.add(new Question("Which class is the root of the Java class hierarchy?", new String[]{"Object", "Class", "Main", "System"}, 0, "Java", "easy"));
        questionBank.add(new Question("Which keyword is used for inheritance in Java?", new String[]{"implements", "inherits", "extends", "super"}, 2, "Java", "easy"));
        questionBank.add(new Question("Which package contains GUI components like JFrame?", new String[]{"java.io", "java.util", "java.net", "javax.swing"}, 3, "Java", "easy"));

        // Hard Java
        questionBank.add(new Question("What modifier makes a variable unchangeable?", new String[]{"static", "final", "const", "immutable"}, 1, "Java", "hard"));
        questionBank.add(new Question("Which polymorphism happens at compile time?", new String[]{"Overriding", "Overloading", "Dynamic", "Runtime"}, 1, "Java", "hard"));
        questionBank.add(new Question("Which method is called by the garbage collector?", new String[]{"dispose()", "free()", "finalize()", "clean()"}, 2, "Java", "hard"));
        questionBank.add(new Question("Can we instantiate an Abstract Class directly?", new String[]{"Yes", "No", "Depends on methods", "Yes, if no abstract methods"}, 1, "Java", "hard"));
        questionBank.add(new Question("What does JIT stand for in Java context?", new String[]{"Just In Time", "Java In Time", "Joint Implementation", "Java Integrated"}, 0, "Java", "hard"));
        questionBank.add(new Question("Which JVM component runs the Java bytecode?", new String[]{"Execution Engine", "Classloader", "Memory Area", "JNI"}, 0, "Java", "hard"));
        questionBank.add(new Question("Which is NOT a Checked Exception?", new String[]{"IOException", "SQLException", "ClassNotFoundException", "NullPointerException"}, 3, "Java", "hard"));
        questionBank.add(new Question("What is the default initial capacity of ArrayList?", new String[]{"0", "10", "16", "20"}, 1, "Java", "hard"));
        questionBank.add(new Question("Which collection class is synchronized?", new String[]{"ArrayList", "LinkedList", "Vector", "HashSet"}, 2, "Java", "hard"));
        questionBank.add(new Question("Which layout manager arranges components in a grid of cells?", new String[]{"FlowLayout", "BorderLayout", "GridLayout", "BoxLayout"}, 2, "Java", "hard"));


        // ---- CSS Questions ----
        // Easy CSS
        questionBank.add(new Question("What does CSS stand for?", new String[]{"Creative Style Sheets", "Cascading Style Sheets", "Computer Style Sheets", "Colorful Style Sheets"}, 1, "CSS", "easy"));
        questionBank.add(new Question("Which HTML tag is used to define internal CSS?", new String[]{"<css>", "<script>", "<style>", "<link>"}, 2, "CSS", "easy"));
        questionBank.add(new Question("Which HTML attribute links to external CSS?", new String[]{"src", "class", "style", "href"}, 3, "CSS", "easy"));
        questionBank.add(new Question("Which property changes the background color?", new String[]{"bg-color", "color", "background-color", "bgColor"}, 2, "CSS", "easy"));
        questionBank.add(new Question("Which CSS property changes text color?", new String[]{"text-color", "fgcolor", "color", "font-color"}, 2, "CSS", "easy"));
        questionBank.add(new Question("How do you select an element with id 'demo'?", new String[]{"#demo", ".demo", "demo", "*demo"}, 0, "CSS", "easy"));
        questionBank.add(new Question("How do you select elements with class 'test'?", new String[]{"#test", ".test", "test", "*test"}, 1, "CSS", "easy"));
        questionBank.add(new Question("Which property adds space inside the element border?", new String[]{"margin", "spacing", "padding", "border-spacing"}, 2, "CSS", "easy"));
        questionBank.add(new Question("Which property adds space outside the element border?", new String[]{"margin", "spacing", "padding", "border-spacing"}, 0, "CSS", "easy"));
        questionBank.add(new Question("How do you make text bold in CSS?", new String[]{"font: bold", "font-weight: bold", "text-style: bold", "bold: true"}, 1, "CSS", "easy"));

        // Hard CSS
        questionBank.add(new Question("Which CSS property controls the box model calculations?", new String[]{"box-sizing", "box-model", "calc", "border-box"}, 0, "CSS", "hard"));
        questionBank.add(new Question("What is the default value of the position property?", new String[]{"relative", "absolute", "fixed", "static"}, 3, "CSS", "hard"));
        questionBank.add(new Question("Which selector selects direct children?", new String[]{"div + p", "div > p", "div p", "div ~ p"}, 1, "CSS", "hard"));
        questionBank.add(new Question("Which property creates a flex container?", new String[]{"display: flex", "flex-container: true", "layout: flex", "position: flex"}, 0, "CSS", "hard"));
        questionBank.add(new Question("Which property aligns flex items along the cross axis?", new String[]{"justify-content", "align-items", "align-content", "align-self"}, 1, "CSS", "hard"));
        questionBank.add(new Question("What does 'vh' stand for in CSS?", new String[]{"Vertical Height", "View Height", "Viewport Height", "Visual Height"}, 2, "CSS", "hard"));
        questionBank.add(new Question("Which property hides an element but keeps its space?", new String[]{"display: none", "visibility: hidden", "opacity: 0", "Both B and C"}, 3, "CSS", "hard"));
        questionBank.add(new Question("What is a CSS pseudo-element?", new String[]{":hover", "::before", ":active", ":first-child"}, 1, "CSS", "hard"));
        questionBank.add(new Question("Which CSS rule imports another stylesheet?", new String[]{"@include", "@import", "@stylesheet", "@require"}, 1, "CSS", "hard"));
        questionBank.add(new Question("What does z-index control?", new String[]{"Zoom level", "Stack order", "Transparency", "Width/Height aspect"}, 1, "CSS", "hard"));


        // ---- Python Questions ----
        // Easy Python
        questionBank.add(new Question("How do you declare a list in Python?", new String[]{"[]", "{}", "()", "list[]"}, 0, "Python", "easy"));
        questionBank.add(new Question("What creates a function in Python?", new String[]{"function", "def", "create", "func"}, 1, "Python", "easy"));
        questionBank.add(new Question("Which function prints to console?", new String[]{"console.log()", "print()", "echo()", "write()"}, 1, "Python", "easy"));
        questionBank.add(new Question("What symbol is used for comments in Python?", new String[]{"//", "/*", "#", "<!--"}, 2, "Python", "easy"));
        questionBank.add(new Question("Which operator performs exponentiation?", new String[]{"^", "**", "//", "exp"}, 1, "Python", "easy"));
        questionBank.add(new Question("What data type is the result of 3.0 + 2?", new String[]{"int", "float", "double", "str"}, 1, "Python", "easy"));
        questionBank.add(new Question("Which is NOT a valid Python loop?", new String[]{"for", "while", "do-while", "All are valid"}, 2, "Python", "easy"));
        questionBank.add(new Question("How to get length of a list 'myList'?", new String[]{"myList.length", "length(myList)", "len(myList)", "myList.len()"}, 2, "Python", "easy"));
        questionBank.add(new Question("Which of the following is immutable?", new String[]{"List", "Dictionary", "Tuple", "Set"}, 2, "Python", "easy"));
        questionBank.add(new Question("How to get data from user?", new String[]{"scan()", "input()", "read()", "cin"}, 1, "Python", "easy"));

        // Hard Python
        questionBank.add(new Question("What does the 'pass' keyword do?", new String[]{"Ends loop", "Skips iteration", "Does nothing", "Throws error"}, 2, "Python", "hard"));
        questionBank.add(new Question("What is the result of 'type(lambda x: x)'?", new String[]{"<class 'function'>", "<class 'lambda'>", "<type 'closure'>", "<class 'method'>"}, 0, "Python", "hard"));
        questionBank.add(new Question("Which decorator is used to create a class method?", new String[]{"@classmethod", "@staticmethod", "@class", "@method"}, 0, "Python", "hard"));
        questionBank.add(new Question("What is a Python 'generator'?", new String[]{"Function returning list", "Function with 'yield'", "A class type", "Module builder"}, 1, "Python", "hard"));
        questionBank.add(new Question("Which of these copies a dictionary shallowly?", new String[]{"dict.copy()", "dict.clone()", "dict(dict)", "Both A and C"}, 3, "Python", "hard"));
        questionBank.add(new Question("What is the GIL?", new String[]{"Global Interpreter Lock", "General Interface Layer", "Global Integration Loop", "Generic In-Line"}, 0, "Python", "hard"));
        questionBank.add(new Question("What does '*args' allow in a function?", new String[]{"Keyword args", "Variable positional args", "Tuple unpacking", "Dictionary mapping"}, 1, "Python", "hard"));
        questionBank.add(new Question("How do you implement a private variable in Python?", new String[]{"private x", "__x", "_x", "None of above"}, 1, "Python", "hard"));
        questionBank.add(new Question("What is a set in Python?", new String[]{"Ordered list", "Unordered list of unique elements", "Key-Value pairs", "Matrix"}, 1, "Python", "hard"));
        questionBank.add(new Question("What is __init__?", new String[]{"Class initialization module", "Constructor method", "Destructor", "Garbage collection tag"}, 1, "Python", "hard"));
    }

    /**
     * Endpoint to fetch exactly 10 questions for a topic and difficulty level.
     */
    @GetMapping("/questions")
    public List<Question> getQuestions(@RequestParam String topic, @RequestParam String level) {
        return questionBank.stream()
                .filter(q -> q.getTopic().equalsIgnoreCase(topic) && q.getLevel().equalsIgnoreCase(level))
                .limit(10) // Strictly 10 questions
                .collect(Collectors.toList());
    }
}
