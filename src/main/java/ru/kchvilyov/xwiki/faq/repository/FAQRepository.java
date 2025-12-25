package ru.kchvilyov.xwiki.faq.repository;

import ru.kchvilyov.xwiki.faq.entity.FAQEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQRepository extends JpaRepository<FAQEntry, Long> {
}