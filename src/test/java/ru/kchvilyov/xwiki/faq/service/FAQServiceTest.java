package ru.kchvilyov.xwiki.faq.service;

import ru.kchvilyov.xwiki.faq.entity.FAQEntry;
import ru.kchvilyov.xwiki.faq.repository.FAQRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FAQServiceTest {

    @Mock
    private FAQRepository faqRepository;

    @InjectMocks
    private FAQService faqService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFaqById_IncrementsViewCount() {
        Long id = 1L;
        FAQEntry entry = new FAQEntry("What is Java?", "A programming language.", "admin");
        entry.setId(id);
        entry.setViewCount(5);

        when(faqRepository.findById(id)).thenReturn(Optional.of(entry));
        when(faqRepository.save(any(FAQEntry.class))).thenAnswer(invocation -> invocation.getArgument(0));

        FAQEntry result = faqService.getFaqById(id);

        assertEquals(6, result.getViewCount());
        verify(faqRepository).save(entry);
    }

    @Test
    void testCreateFAQ_ValidEntry() {
        FAQEntry entry = new FAQEntry("What is Spring?", "A framework.", "admin");

        when(faqRepository.save(entry)).thenReturn(entry);

        FAQEntry result = faqService.createFAQ(entry);

        assertEquals("What is Spring?", result.getQuestion());
        verify(faqRepository).save(entry);
    }
}