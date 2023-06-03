package il.ac.hit.course.designPattern;

import il.ac.hit.course.designPattern.ChatException;

public interface StringConsumer {
    public void consume(String text) throws ChatException;
}
