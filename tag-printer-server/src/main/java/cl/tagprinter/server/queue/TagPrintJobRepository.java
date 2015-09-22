package cl.tagprinter.server.queue;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagPrintJobRepository extends JpaRepository<TagPrintJob, Long> {

}
