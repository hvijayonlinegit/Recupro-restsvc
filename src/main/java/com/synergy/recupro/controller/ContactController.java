//package com.synergy.recupro.controller;
//
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.synergy.recupro.model.Company;
//import com.synergy.recupro.model.Contact;
//import com.synergy.recupro.model.Person;
//import com.synergy.recupro.repository.CompanyRepository;
//import com.synergy.recupro.repository.PersonRepository;
//import com.synergy.recupro.repository.ContactRepository;
//
///**
// * Controller class for testing contact's repositories classes.
// *
// * @author netgloo
// */
//@Controller
//public class ContactController {
//
//  // ==============
//  // PRIVATE FIELDS
//  // ==============
//
//  @Autowired
//  private CompanyRepository companyRepository;
//
//  @Autowired
//  private PersonRepository personRepository;
//
//  @Autowired
//  private ContactRepository contactRepository;
//
//  // ==============
//  // PUBLIC METHODS
//  // ==============
//  
//  /**
//   * /contact/create/person?email=[email]&firstName=[firstName] -> create a new 
//   * person contact and save it in the database.
//   * 
//   * @param email The person's email
//   * @param firstName The person's first name
//   * @return a string describing if the person is succesfully created or not.
//   */
//  @RequestMapping("/contact/create/person")
//  @ResponseBody
//  public String createPerson(String email, String firstName) {
//    try {
//      Person person = new Person();
//      person.setEmail(email);
//      person.setFirstName(firstName);
//      personRepository.save(person);
//    }
//    catch (Exception ex) {
//      return "Error creating the person: " + ex.toString();
//    }
//    return "Person succesfully created!";
//  }
//
//  /**
//   * /contact/create/company?email=[email]&name=[name] -> create a new company 
//   * contact and save it in the database.
//   * 
//   * @param email The company's email
//   * @param name The company's name
//   * @return A string describing if the company is succesfully created or not.
//   */
//  @RequestMapping("/contact/create/company")
//  @ResponseBody
//  public String createCompany(String email, String name) {
//    try {
//      Company company = new Company();
//      company.setEmail(email);
//      company.setName(name);
//      companyRepository.save(company);
//    }
//    catch (Exception ex) {
//      return "Error creating the company: " + ex.toString();
//    }
//    return "Company succesfully created!";
//  }
//
//  /**
//   * /contact/delete?id=[id] -> delete the contact having the passed id.
//   * 
//   * @param id The id for the contact to delete
//   * @return A string describing if the contact is succesfully deleted or not.
//   */
//  @RequestMapping("/contact/delete")
//  @ResponseBody
//  public String deleteContact(long id) {
//    try {
//      //contactRepository.delete(contactRepository.findOne(id));
//    }
//    catch (Exception ex) {
//      return "Error deleting the contact:" + ex.toString();
//    }
//    return "contact succesfully deleted!";
//  }
//  
//  /**
//   * /contact/delete/person?id=[id] -> delete the person contact having the passed id.
//   * 
//   * @param id The id for the person to delete
//   * @return A string describing if the person is succesfully deleted or not.
//   */
//  @RequestMapping("/contact/delete/person")
//  @ResponseBody
//  public String deletePerson(long id) {
//    try {
//      personRepository.delete(new Person(id));
//    }
//    catch (Exception ex) {
//      return "Error deleting the contact:" + ex.toString();
//    }
//    return "contact succesfully deleted!";
//  }
//  
//  /**
//   * /contact/get?email=[email] -> return the contact having the passed email.
//   * 
//   * @param email The email to search in the database.
//   * @return The contact id or a message error if the contact is not found.
//   */
//  @RequestMapping("/contact/get")
//  @ResponseBody
//  public String getContact(String email) {
//    String contactId = "";
//    String contactType = "";
//    try {
//      Contact contact = contactRepository.findByEmail(email);
//      contactId = String.valueOf(contact.getId());
//      
//      // get the contact type
//      if (contact instanceof Person)
//        contactType = "Person";
//      else if (contact instanceof Company)
//        contactType = "Company";
//      
//    }
//    catch (Exception ex) {
//      return "contact not found";
//    }
//    return "The " + contactType + " id is: " + contactId;
//  }
//  
//  /**
//   * /contact/update?id=[id]&email=[email]&name=[name] -> get the contact with passed
//   * id and change its email and name (the firstName if the contact is of type 
//   * Person).
//   * 
//   * @param id The id of the contact to update.
//   * @param email The new email value.
//   * @param name The new name for the contact.
// * @return 
//   * @return A string describing if the contact is succesfully updated or not.
//   */
////  @RequestMapping("/contact/update")
////  @ResponseBody
////  public String update(Long id, String email, String name) {
////    try {
////      Contact contact = contactRepository.findOne(id);
////      contact.setEmail(email);
////      
//////       switch on the contact type
////      if (contact instanceof Person) {
////        Person person = (Person)contact;
////        person.setFirstName(name);
////      }
////      if (contact instanceof Company) {
////        Company company = (Company)contact;
////        company.setName(name);
////      }
////      
//////       updates the contact accordingly to its type (Person or Company)
////      contactRepository.save(contact);
////    }
////    catch (Exception ex) {
////      return "Error: " + ex.toString();
////    }
////    return "contact successfully updated.";
////  }
//  @RequestMapping("/contact/all")
//  @ResponseBody
//  public List<Contact> getALL() {
//    try {
//           return contactRepository.findAll();
//    }
//    catch (Exception ex) {
//     // return "Error: " + ex.toString();
//    }
//    return null;
//  }
//  @RequestMapping("/contact/person/all")
//  @ResponseBody
//  public List<Contact> getPersonsAll() {
//    try {
//    	List<Contact>  contacts= contactRepository.findAll();
//    	return contacts.stream().filter(sc -> sc instanceof Person).collect(Collectors.toList());
//    }
//    catch (Exception ex) {
//     // return "Error: " + ex.toString();
//    }
//    return null;
//  }
//  
//} // class ContactController
//
