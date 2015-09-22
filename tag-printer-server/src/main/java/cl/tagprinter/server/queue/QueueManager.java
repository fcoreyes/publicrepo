package cl.tagprinter.server.queue;

public interface QueueManager {
	public Long enqueuePrintJob(String type, String requestor);
}
