package Job.App.Job.App.Service.ServiceImpl;

import Job.App.Job.App.Model.Company;
import Job.App.Job.App.Model.Job;
import Job.App.Job.App.Repository.CompanyRepository;
import Job.App.Job.App.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll() ;
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if(companyOptional.isPresent() ){
            Company company1 = companyOptional.get();
            company1.setDescription(company.getDescription());
            company1.setName(company.getName());
            company1.setJobs(company.getJobs());
            companyRepository.save(company1);
            return true;
        }

        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);

    }

    @Override
    public boolean delete(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public Company getCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()){
            return company.get();
        }
        return null;

    }
}
