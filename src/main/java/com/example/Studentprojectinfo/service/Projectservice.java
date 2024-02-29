package com.example.Studentprojectinfo.service;

import com.example.Studentprojectinfo.dto.Projectrequest;
import com.example.Studentprojectinfo.exception.UserNotFoundException;
import com.example.Studentprojectinfo.model.Project;
import com.example.Studentprojectinfo.repository.projectrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Projectservice {
@Autowired
private projectrepository repo;

    public  List<Project> getproject() {
        return repo.findAll();
    }

    public Project saveproject(Projectrequest projectrequest) {
    Project project = new Project();

    project.setRollno(projectrequest.getRollno());
    project.setName(projectrequest.getName());
    project.setBatch(projectrequest.getBatch());
    project.setEmail(projectrequest.getEmail());
    project.setPhone(projectrequest.getPhone());
    project.setDepartment(projectrequest.getDepartment());
    project.setSemester(projectrequest.getSemester());
    project.setProjectname(projectrequest.getProjectname());
    project.setDescription(projectrequest.getDescription());
    project.setStatus(projectrequest.getStatus());
    project.setSupervisor(projectrequest.getSupervisor());
    project.setHodname(projectrequest.getHodname());
    project.setDate(projectrequest.getDate());
    project.setTopic(projectrequest.getTopic());
    project.setGithublink(projectrequest.getGithublink());
    project.setProjectlink(projectrequest.getProjectlink());

        return repo.save(project);
    }


    public Project getProjects(int id) {
        return repo.findById(id).get();
    }

    public void deleteProjects(int id) {
        repo.deleteById(id);
    }

    public Project updateProjects(int id, Project project) {
        Project existingproject = repo.findById(id).get();
        existingproject.setRollno(project.getRollno());
        existingproject.setName(project.getName());
        existingproject.setBatch(project.getBatch());
        existingproject.setEmail(project.getEmail());
        existingproject.setPhone(project.getPhone());
        existingproject.setDepartment(project.getDepartment());
        existingproject.setSemester(project.getSemester());
        existingproject.setProjectname(project.getProjectname());
        existingproject.setDescription(project.getDescription());
        existingproject.setStatus(project.getStatus());
        existingproject.setSupervisor(project.getSupervisor());
        existingproject.setHodname(project.getHodname());
        existingproject.setDate(project.getDate());
        existingproject.setTopic(project.getTopic());
        existingproject.setGithublink(project.getGithublink());
        existingproject.setProjectlink(project.getProjectlink());

        return repo.save(existingproject);

    }


    public List<Project> saveprojects(List<Project> projects) {
        return repo.saveAll(projects);
    }
    public Project getProjectByRollno(String rollno) throws UserNotFoundException {
        Project p = repo.findByRollno(rollno);
        if(p != null){
            return p;
        } else {
            throw new UserNotFoundException("User not found with roll number: " + rollno);
        }
    }
}
