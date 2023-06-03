package il.ac.hit.course.designPattern;

import il.ac.hit.course.designPattern.StringConsumer;

public interface StringProducer {
    public void addConsumer(StringConsumer consumer);
    public void removeConsumer(StringConsumer consumer);
}
