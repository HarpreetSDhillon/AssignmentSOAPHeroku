/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.mycompany.assignmentsoapservice.Library;
import com.mycompany.assignmentsoapservice.LibraryJpaController;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.ws.soap.MTOM;

/**
 *
 * @author Harpreet
 */
@WebService(serviceName = "CrudLibrary")
@MTOM(enabled = true, threshold = 100000)
@HandlerChain(file = "/CrudLibrary_handler.xml")
public class CrudLibrary {
    @WebMethod(operationName = "addMovie")
    public String addMovie(Library lib) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        LibraryJpaController libRepo = new LibraryJpaController(emf);
        if(lib.getId()==null){
                List<Library> showList = libRepo.findLibraryEntities();
                List<BigDecimal> ids = new ArrayList<BigDecimal>();
                for (Library l : showList) {
                    ids.add(l.getId());
                }
                if(ids.isEmpty()){
                    lib.setId(BigDecimal.ONE);
                }
                else
                    lib.setId(Collections.max(ids).add(BigDecimal.ONE));
            libRepo.create(lib);
            System.out.println(lib.getId());

            return "Created";
            }else{
            libRepo.edit(lib);
            System.out.println(lib.getId());

            return "Updated";
        }
        
    }
    
    @WebMethod
    public Library getLib(int id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        LibraryJpaController libRepo = new LibraryJpaController(emf);
        
        Library lib = libRepo.findLibraryEntities().stream()
                .filter(x -> x.getId().equals(BigDecimal.valueOf(id))).findFirst().orElse(null);
        
        if(lib !=null){
            return lib;
        }else
            return null;
        
    }
    
    @WebMethod
    public List<Library> getAllLib() throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        LibraryJpaController libRepo = new LibraryJpaController(emf);
        
        List<Library> lib = libRepo.findLibraryEntities();
        
        if(lib !=null){
            return lib;
        }else
            return null;
        
    }
    
    @WebMethod
    public String Update(Library library) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        LibraryJpaController libRepo = new LibraryJpaController(emf);
        
        Library lib = libRepo.findLibraryEntities().stream()
                .filter(x -> x.getId().equals(library.getId())).findFirst().orElse(null);
        library.setId(lib.getId());
        if(lib !=null){
            libRepo.edit(library);
            return "Updated";
        }else
            return null;
        
    }
    
    @WebMethod
    public String delete(int id) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        LibraryJpaController libRepo = new LibraryJpaController(emf);
        
        Library lib = libRepo.findLibraryEntities().stream()
                .filter(x -> x.getId().equals(BigDecimal.valueOf(id))).findFirst().orElse(null);
        
        if(lib !=null){
            libRepo.destroy(BigDecimal.valueOf(id));
            return "Deleted";
        }else
            return "Already Deleted";
        
    }
}
