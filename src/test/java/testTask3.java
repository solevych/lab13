
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ucu.edu.ua.task3.*;


public class testTask3 {

    private CompanyReaderFacade companyReaderFacade;
    private PDLReader pdlReader;
    private BrandFetchReader brandFetchReader;


    @BeforeEach
    void setUp() {
        companyReaderFacade = new CompanyReaderFacade();
        pdlReader = new PDLReader();
        brandFetchReader = new BrandFetchReader();
    }

    @Test
    void testFetchFromPDLReader() {
        Company company = pdlReader.fetch("ucu.edu.ua");
        assertNotNull(company, "Company should not be null from PDLReader");
    }

    @Test
    void testFetchFromBrandFetchReader() {
        Company company = brandFetchReader.fetch("ucu.edu.ua");
        assertNotNull(company, "Company should not be null from BrandFetchReader");
        assertTrue(company.getName() != null || company.getDescription() != null, 
                   "Company should have at least a name or description");
    }

    @Test
    void testCompanyReaderFacadeFetch() {
        Company company = companyReaderFacade.fetch("ucu.edu.ua");
        assertNotNull(company, "Company should not be null from CompanyReaderFacade");
        assertNotNull(company.getName(), "Company name should not be null after merging results");
    }

    @Test
    void testMergeCompanies() {
        Company company1 = new Company();
        company1.setName("Company from PDL");

        Company company2 = new Company();
        company2.setName("Company from BrandFetch");

        Company mergedCompany = companyReaderFacade.fetch("ucu.edu.ua");

        assertNotNull(mergedCompany.getName(), "Merged company should have a name");
    }
}
