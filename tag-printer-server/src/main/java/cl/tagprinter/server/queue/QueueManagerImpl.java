package cl.tagprinter.server.queue;

import org.springframework.beans.factory.annotation.Autowired;

public class QueueManagerImpl implements QueueManager {

	@Autowired
	private TagPrintJobRepository repository;

	public TagPrintJobRepository getRepository() {
		return repository;
	}

	public void setRepository(TagPrintJobRepository repository) {
		this.repository = repository;
	}

	@Override
	public Long enqueuePrintJob(String type, String requestor) {
		TagPrintJob job = new TagPrintJob();
		job.setType(type);
		job.setRequestor(requestor);
		repository.save(job);
		return job.getId();
	}

}
