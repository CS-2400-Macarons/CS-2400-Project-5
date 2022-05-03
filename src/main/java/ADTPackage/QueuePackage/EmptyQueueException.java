package ADTPackage.QueuePackage;

import java.util.NoSuchElementException;

public class EmptyQueueException extends NoSuchElementException
{
    public EmptyQueueException()
    {
        super("Queue is Empty");
    }
}
