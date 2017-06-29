/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.services;

import br.com.crescer.aula7.Video;
import br.com.crescer.aula7.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
        @Autowired
        VideoRepository videoRepository;
        
        public Iterable<Video> listAll(){
        
            return videoRepository.findAll();
        }

                

}