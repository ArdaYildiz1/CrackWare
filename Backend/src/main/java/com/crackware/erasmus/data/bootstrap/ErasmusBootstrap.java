package com.crackware.erasmus.data.bootstrap;

import com.crackware.erasmus.data.model.*;
import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.model.security.EnumRole;
import com.crackware.erasmus.data.model.security.Role;
import com.crackware.erasmus.data.model.security.User;
import com.crackware.erasmus.data.repositories.*;
import com.crackware.erasmus.data.repositories.security.RoleRepository;
import com.crackware.erasmus.data.repositories.security.UserRepository;
import com.crackware.erasmus.data.services.InternationalStudentOfficeService;
import com.crackware.erasmus.data.services.StudentService;
import com.crackware.erasmus.data.services.ToDoListItemService;
import com.crackware.erasmus.data.services.ToDoListService;
import com.crackware.erasmus.data.services.helper.ExcelService;
import com.crackware.erasmus.web.controller.TestController;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;

@Component
public class ErasmusBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final StudentService studentService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final CoordinatorRepository coordinatorRepository;
    private final ToDoListItemService toDoListItemService;
    private final FacultyBoardMemberRepository facultyBoardMemberRepository;
    private final TestController testController;

    private final ToDoListService toDoListService;
    private final ExcelService excelService;
    private final InstructorRepository instructorRepository;
    private final InternationalStudentOfficeService internationalStudentOfficeService;

    public ErasmusBootstrap(StudentService studentService, RoleRepository roleRepository,
                            UserRepository userRepository, CoordinatorRepository coordinatorRepository,
                            ToDoListItemService toDoListItemService,
                            FacultyBoardMemberRepository facultyBoardMemberRepository,
                            TestController testController, ToDoListService toDoListService, ExcelService excelService,
                            InstructorRepository instructorRepository,
                            InternationalStudentOfficeService internationalStudentOfficeService) {
        this.studentService = studentService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.coordinatorRepository = coordinatorRepository;
        this.toDoListItemService = toDoListItemService;
        this.facultyBoardMemberRepository = facultyBoardMemberRepository;
        this.testController = testController;
        this.toDoListService = toDoListService;
        this.excelService = excelService;
        this.instructorRepository = instructorRepository;
        this.internationalStudentOfficeService = internationalStudentOfficeService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // set To Do Lists
        ToDoList coordinatorToDoList = new ToDoList();
        toDoListService.save(coordinatorToDoList);



        // set roles
        Role sRole = new Role();
        Role cRole = new Role();
        Role fRole = new Role();
        Role iRole = new Role();
        Role isoRole = new Role();
        cRole.setName(EnumRole.ROLE_COORDINATOR);
        sRole.setName(EnumRole.ROLE_STUDENT);
        fRole.setName(EnumRole.ROLE_FACULTY_BOARD_MEMBER);
        iRole.setName(EnumRole.ROLE_INSTRUCTOR);
        isoRole.setName(EnumRole.ROLE_ISO);
        roleRepository.save(sRole);
        roleRepository.save(cRole);
        roleRepository.save(fRole);
        roleRepository.save(iRole);
        roleRepository.save(isoRole);

        // set users
        User uCem = new User();
        User uEren = new User();
        User uElif = new User();
        User uAsli = new User();
        User uArda = new User();
        User uCanAlkan = new User();
        User uAysegulDundar = new User();
        User uSaksoy = new User();
        User uEray = new User();
        User isoUser = new User();
        uCem.setEmail("cemg@hotmail.com");
        uCem.setPassword("$2a$12$YgweTD5c62YwUasYujnRa.Puit4Irrxdq3qXDXCwr5nV1yfXcFxvy");
        HashSet<Role> cemRoles = new HashSet<>(); cemRoles.add(sRole);
        uCem.setRoles(cemRoles);
        userRepository.save(uCem);
        uElif.setEmail("eoz@hotmail.com");
        uElif.setPassword("$2a$12$YgweTD5c62YwUasYujnRa.Puit4Irrxdq3qXDXCwr5nV1yfXcFxvy");
        HashSet<Role> elifRoles = new HashSet<>(); elifRoles.add(sRole);
        uElif.setRoles(elifRoles);
        userRepository.save(uElif);
        uEren.setEmail("eduran@hotmail.com");
        uEren.setPassword("$2a$12$YgweTD5c62YwUasYujnRa.Puit4Irrxdq3qXDXCwr5nV1yfXcFxvy");
        HashSet<Role> erenRoles = new HashSet<>(); erenRoles.add(sRole);
        uEren.setRoles(erenRoles);
        userRepository.save(uEren);
        uAsli.setEmail("akaraman@hotmail.com");
        uAsli.setPassword("$2a$12$YgweTD5c62YwUasYujnRa.Puit4Irrxdq3qXDXCwr5nV1yfXcFxvy");
        HashSet<Role> asliRoles = new HashSet<>(); asliRoles.add(sRole);
        uAsli.setRoles(asliRoles);
        userRepository.save(uAsli);
        uArda.setEmail("ayildiz@hotmail.com");
        uArda.setPassword("$2a$12$YgweTD5c62YwUasYujnRa.Puit4Irrxdq3qXDXCwr5nV1yfXcFxvy");
        HashSet<Role> ardaRoles = new HashSet<>(); ardaRoles.add(sRole);
        uArda.setRoles(ardaRoles);
        userRepository.save(uArda);
        uCanAlkan.setEmail("calkan@hotmail.com");
        uCanAlkan.setPassword("$2a$12$YgweTD5c62YwUasYujnRa.Puit4Irrxdq3qXDXCwr5nV1yfXcFxvy");
        HashSet<Role> calkanRoles = new HashSet<>(); calkanRoles.add(cRole);
        uCanAlkan.setRoles(calkanRoles);
        userRepository.save(uCanAlkan);
        uAysegulDundar.setEmail("adundar@hotmail.com");
        uAysegulDundar.setPassword("$2a$12$YgweTD5c62YwUasYujnRa.Puit4Irrxdq3qXDXCwr5nV1yfXcFxvy");
        HashSet<Role> aduranRoles = new HashSet<>(); aduranRoles.add(cRole);
        uAysegulDundar.setRoles(aduranRoles);
        userRepository.save(uAysegulDundar);
        uSaksoy.setEmail("saksoy@hotmail.com");
        uSaksoy.setPassword("$2a$12$YgweTD5c62YwUasYujnRa.Puit4Irrxdq3qXDXCwr5nV1yfXcFxvy");
        HashSet<Role> saksoyRoles = new HashSet<>(); saksoyRoles.add(fRole);
        uSaksoy.setRoles(saksoyRoles);
        userRepository.save(uSaksoy);
        uEray.setEmail("etuzun@hotmail.com");
        uEray.setPassword("$2a$12$YgweTD5c62YwUasYujnRa.Puit4Irrxdq3qXDXCwr5nV1yfXcFxvy");
        HashSet<Role> erayRoles = new HashSet<>(); erayRoles.add(iRole);
        uEray.setRoles(erayRoles);
        userRepository.save(uEray);
        isoUser.setEmail("iso@hotmail.com");
        isoUser.setPassword("$2a$12$YgweTD5c62YwUasYujnRa.Puit4Irrxdq3qXDXCwr5nV1yfXcFxvy");
        HashSet<Role> isoRoles = new HashSet<>(); isoRoles.add(isoRole);
        isoUser.setRoles(isoRoles);
        userRepository.save(isoUser);

        // set students
        Student cem = new Student();
        Student eren = new Student();
        Student elif = new Student();
        Student asli = new Student();
        Student arda = new Student();
        cem.setDateOfBirth("23.04.2001");
        cem.setMail("cemg@hotmail.com");
        cem.setName("Cem");
        cem.setSurname("Gülümser");
        cem.setAddress("Izmir/Göztepe");
        cem.setBilkentId("22003430");
        cem.setCgpa("3.63");
        cem.setDepartment(Department.CS);
        cem.setEng101grade("A");
        cem.setEng102grade("A");
        cem.setGender("Male");
        cem.setNationalID("41266758526");
        cem.setPhoneNumber("905376314257");
        cem.setTerm(5);
        cem.setRole(sRole);
        studentService.save(cem);
        eren.setDateOfBirth("21.02.2001");
        eren.setMail("eduran@hotmail.com");
        eren.setName("Eren");
        eren.setSurname("Duran");
        eren.setAddress("Ankara/Yenimahalle");
        eren.setBilkentId("22003932");
        eren.setCgpa("3.31");
        eren.setDepartment(Department.CS);
        eren.setEng101grade("A");
        eren.setEng102grade("B");
        eren.setGender("Male");
        eren.setNationalID("12312312321");
        eren.setPhoneNumber("905314258778");
        eren.setTerm(5);
        eren.setRole(sRole);
        studentService.save(eren);
        elif.setDateOfBirth("25.06.2001");
        elif.setMail("eoz@hotmail.com");
        elif.setName("Elif");
        elif.setSurname("Öz");
        elif.setAddress("Antalya/Döşemealtı");
        elif.setBilkentId("22004141");
        elif.setCgpa("3.98");
        elif.setDepartment(Department.CS);
        elif.setEng101grade("A");
        elif.setEng102grade("A");
        elif.setGender("Female");
        elif.setNationalID("12312312321");
        elif.setPhoneNumber("905314258778");
        elif.setTerm(5);
        elif.setRole(sRole);
        studentService.save(elif);
        asli.setDateOfBirth("13.06.2001");
        asli.setMail("akaraman@hotmail.com");
        asli.setName("Asli");
        asli.setSurname("Karaman");
        asli.setAddress("Ankara/Cayyolu");
        asli.setBilkentId("22002121");
        asli.setCgpa("3.40");
        asli.setDepartment(Department.CS);
        asli.setEng101grade("A");
        asli.setEng102grade("B-");
        asli.setGender("Female");
        asli.setNationalID("34534565754");
        asli.setPhoneNumber("905314258778");
        asli.setTerm(5);
        asli.setRole(sRole);
        studentService.save(asli);
        arda.setDateOfBirth("11.03.2001");
        arda.setMail("ayildiz@hotmail.com");
        arda.setName("Arda");
        arda.setSurname("Yıldız");
        arda.setAddress("Ankara/Cayyolu");
        arda.setBilkentId("22001111");
        arda.setCgpa("3.50");
        arda.setDepartment(Department.CS);
        arda.setEng101grade("B-");
        arda.setEng102grade("B-");
        arda.setGender("Male");
        arda.setNationalID("14614668965");
        arda.setPhoneNumber("905314258778");
        arda.setTerm(5);
        arda.setRole(sRole);
        studentService.save(arda);

        // set coordinators
        Coordinator calkan = new Coordinator();
        calkan.setDepartment(Department.CS);
        calkan.setRole(cRole);
        calkan.setMail("calkan@hotmail.com");
        calkan.setName("Can");
        calkan.setSurname("Alkan");
        calkan.setDateOfBirth("21.04.1980");
        calkan.setToDoList(coordinatorToDoList);
        coordinatorRepository.save(calkan);
        Coordinator aduran = new Coordinator();
        aduran.setDepartment(Department.CS);
        aduran.setRole(cRole);
        aduran.setMail("adundar@hotmail.com");
        aduran.setName("Ayşegül");
        aduran.setSurname("Dündar");
        aduran.setDateOfBirth("21.04.1985");
        aduran.setToDoList(coordinatorToDoList);
        coordinatorRepository.save(aduran);

        // set fba
        FacultyBoardMember fbaSaksoy = new FacultyBoardMember();
        fbaSaksoy.setMail("saksoy@hotmail.com");
        fbaSaksoy.setName("Selim");
        fbaSaksoy.setRole(fRole);
        fbaSaksoy.setDateOfBirth("19.03.1975");
        fbaSaksoy.setSurname("Aksoy");
        facultyBoardMemberRepository.save(fbaSaksoy);

        // set coordinators
        Instructor instructorEray = new Instructor();
        instructorEray.setMail("etuzun@hotmail.com");
        instructorEray.setName("Eray");
        instructorEray.setRole(iRole);
        instructorEray.setDateOfBirth("09.11.2001");
        instructorEray.setSurname("Tüzün");
        instructorEray.setDepartment(Department.CS);
        instructorRepository.save(instructorEray);

        // set iso
        InternationalStudentOffice isoPerson = new InternationalStudentOffice();
        isoPerson.setName("Name");
        isoPerson.setSurname("Surname");
        isoPerson.setDateOfBirth("21.01.1991");
        isoPerson.setMail("iso@hotmail.com");
        isoPerson.setRole(isoRole);
        internationalStudentOfficeService.save(isoPerson);

        try {
            File uploadFile = new File("D:\\CrackWare\\Backend\\src\\main\\resources\\Book1.xlsx");
            FileInputStream is =  new FileInputStream(uploadFile);
            MultipartFile file = new MockMultipartFile("file",IOUtils.toByteArray(is));;
            excelService.save(file);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
