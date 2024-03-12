package Job.App.Job.App.Controller;

import Job.App.Job.App.Model.Company;
import Job.App.Job.App.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/all")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCompay(@PathVariable Long id, @RequestBody Company company){

        boolean updated = companyService.updateCompany(id, company);
        if(updated){
            return new ResponseEntity<>("Company details updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added successfully", HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
       boolean deleted =  companyService.delete(id);
       if(deleted){
           return new ResponseEntity<>("Company deleted Successfully", HttpStatus.CREATED);
       }
        return new ResponseEntity<>("Company not found with given id",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getcompany/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if(company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
