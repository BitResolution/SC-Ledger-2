package com.bitresolution.ledger.core.ledger;

import com.bitresolution.UnitTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.VerboseMockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@Category(UnitTest.class)
@RunWith(VerboseMockitoJUnitRunner.class)
public class DefaultReportServiceTest {

    @Mock
    private ReportRepository repository;

    private ReportService service;

    @Before
    public void setup() {
        service = new DefaultReportService(repository);
    }

    @Test
    public void shouldSaveReports() {
        //given
        Report unsavedReport = mock(Report.class);
        Report savedReport = mock(Report.class);
        given(repository.save(unsavedReport)).willReturn(savedReport);
        //when
        Report resulr = service.save(unsavedReport);
        //then
        assertThat(resulr, is(savedReport));
        assertThat(resulr, is(not(unsavedReport)));
        verify(repository).save(unsavedReport);
        verifyNoMoreInteractions(repository);
    }
}
