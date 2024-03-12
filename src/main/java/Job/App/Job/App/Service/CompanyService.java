package Job.App.Job.App.Service;

import Job.App.Job.App.Model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    boolean updateCompany(Long id, Company company);

    void createCompany(Company company);
    boolean delete(Long id);

    Company getCompanyById(Long id);
}
