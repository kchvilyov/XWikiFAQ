package ru.kchvilyov.xwiki.faq.service;

import ru.kchvilyov.xwiki.faq.entity.FAQEntry;
import ru.kchvilyov.xwiki.faq.repository.FAQRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FAQService {

    @Autowired
    private FAQRepository faqRepository;

    @Transactional
    public FAQEntry getFaqById(Long id) {
        FAQEntry entry = faqRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FAQ not found with id: " + id));
        entry.incrementViewCount();
        return faqRepository.save(entry);
    }

    @Transactional
    public FAQEntry createFAQ(FAQEntry faqEntry) {
        if (faqEntry.getQuestion() == null || faqEntry.getQuestion().trim().isEmpty()) {
            throw new IllegalArgumentException("Question cannot be null or empty");
        }
        if (faqEntry.getAnswer() == null || faqEntry.getAnswer().trim().isEmpty()) {
            throw new IllegalArgumentException("Answer cannot be null or empty");
        }
        return faqRepository.save(faqEntry);
    }
}