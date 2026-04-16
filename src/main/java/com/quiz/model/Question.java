package com.quiz.model;

/**
 * Question Model to store the text, options, answer and level.
 */
public class Question {
    private String text;
    private String[] options;
    private int answerIndex;
    private String topic; // Java, CSS, Python
    private String level; // Easy, Hard

    public Question(String text, String[] options, int answerIndex, String topic, String level) {
        this.text = text;
        this.options = options;
        this.answerIndex = answerIndex;
        this.topic = topic;
        this.level = level;
    }

    public String getText() { return text; }
    public String[] getOptions() { return options; }
    public int getAnswerIndex() { return answerIndex; }
    public String getTopic() { return topic; }
    public String getLevel() { return level; }
}
