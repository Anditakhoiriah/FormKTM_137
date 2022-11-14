/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WSA.project.praktek02;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author user
 */
@Controller
public class mycontroller {
    @RequestMapping("/Projectidcard")
    
    public String Projectidcard (@RequestParam ("Name") String text,
                                 @RequestParam ("NIM") String nomer,
                                 @RequestParam ("Tanggal")@DateTimeFormat(pattern = "yyyy-MM-dd")Date date,
                                 @RequestParam ("image") MultipartFile file, Model model,
                                 @RequestParam ("jurusan") String jurusan,
                                 @RequestParam ("email") String email)
            
            
                                 throws IOException {
        SimpleDateFormat tanggal = new SimpleDateFormat("EEEE, yyyy-MM-dd");
        
        String newTanggal = tanggal.format(date);
        
        String blob = Base64.encodeBase64String(file.getBytes());
        String gambar = "data:iamge/jpeg;base64,".concat(blob);
        
         model.addAttribute("Nm", text);
         model.addAttribute("tgl", newTanggal);
         model.addAttribute("gmbr",gambar);
         model.addAttribute("nomer", nomer);
         model.addAttribute("jrsn", jurusan);
         model.addAttribute("email", email);
         
        
         
         return "kartu";
         
         
         
         
         
                        
    }
    
    
    
}          
    
