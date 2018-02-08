/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experience.services;

import com.esprit.entite.Experience;
import java.util.List;

/**
 *
 * @author ghada
 */
public interface IExperienceService {
    public void createExperience(Experience e);
    public List <Experience> getAllExperience();
    public Experience getExperiencebyId (int idExperience);
    public boolean deleteExperience(int idexperience);
    public boolean deleteExperience (Experience e);
    public boolean updateExperience (Experience e);
    public boolean updateExperience (int e);
    
    
}
