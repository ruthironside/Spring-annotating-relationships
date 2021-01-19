package com.example.filesAndFolders.components;


import com.example.filesAndFolders.models.File;
import com.example.filesAndFolders.models.Folder;
import com.example.filesAndFolders.models.User;
import com.example.filesAndFolders.repository.FileRepository;
import com.example.filesAndFolders.repository.FolderRepository;
import com.example.filesAndFolders.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;


    public DataLoader(){

    }


    public void run(ApplicationArguments args) throws Exception {
        User bob = new User("Bob");
        userRepository.save(bob);

        User tom = new User("Tom");
        userRepository.save(tom);

        User annie = new User("Annie");
        userRepository.save(annie);

        Folder photos = new Folder("Photos", annie);
        folderRepository.save(photos);

        Folder documents = new Folder("Documents", tom);
        folderRepository.save(documents);

        Folder applications = new Folder("Applications", bob);
        folderRepository.save(applications);

        File file1 = new File("filename1", "jpeg", 100, applications);
        fileRepository.save(file1);

        File file2 = new File("filename2", "png", 30, photos);
        fileRepository.save(file2);

        File file3 = new File("filename3", "zip", 200, documents);
        fileRepository.save(file3);






    }
}
