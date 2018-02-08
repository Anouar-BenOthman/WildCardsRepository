/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package experience.services;

import com.esprit.entite.Image;
import java.util.List;

/**
 *
 * @author ghada
 */
public interface IImageService {
     public void addImage(Image i);
    public List <Image> getAllImage();
    public Image getImagebyId (int idImage);
    public boolean deleteImage(int idImage);
    public boolean deleteImage (Image i);
}
