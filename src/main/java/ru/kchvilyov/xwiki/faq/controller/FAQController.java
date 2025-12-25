package ru.kchvilyov.xwiki.faq.controller;

import ru.kchvilyov.xwiki.faq.entity.FAQEntry;
import ru.kchvilyov.xwiki.faq.service.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faq")
public class FAQController {

    @Autowired
    private FAQService faqService;

    @GetMapping("/{id}")
    public ResponseEntity<FAQEntry> getFAQ(@PathVariable Long id) {
        FAQEntry faq = faqService.getFaqById(id);
        return ResponseEntity.ok(faq);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FAQEntry createFAQ(@RequestBody FAQEntry faqEntry) {
        return faqService.createFAQ(faqEntry);
    }
}