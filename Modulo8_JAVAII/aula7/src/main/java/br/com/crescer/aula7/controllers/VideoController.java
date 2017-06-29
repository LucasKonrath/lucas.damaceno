/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.controllers;


import br.com.crescer.aula7.Video;
import br.com.crescer.aula7.services.VideoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carlos H. Nonnemacher
 */
@RestController
public class VideoController {

    @Autowired
    private VideoService vs;

    @GetMapping(value = "/video")
    Iterable<Video> toIndex() {        
        return vs.listAll();
    }
    
    @GetMapping(value = "/video/{ID}")
    public Video vid (@PathVariable Long ID){
    
        return vs.getById(ID);
    }
    
    @PostMapping(value = "/video")
    public void adicionar(@RequestBody Video vid) {
        vs.addVideo(vid);
    }
    
    @PutMapping(value = "/video")
    public void modificar(@RequestBody Video vid) {
        vs.addVideo(vid);
    }
    
    @DeleteMapping(value = "/video/{ID}")
    public void deletarVideo(@PathVariable Long ID){
        vs.deletar(vs.getById(ID));
    }

}