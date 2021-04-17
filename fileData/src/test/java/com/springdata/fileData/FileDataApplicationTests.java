package com.springdata.fileData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.fileData.entity.Image;
import com.springdata.fileData.repository.ImageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class FileDataApplicationTests {
	
	@Autowired
	private ImageRepository imageRepository;

	@Test
	void contextLoads() {
	}

	
	@Test
	void testInsertImage() throws IOException{
		Image image = new Image();
		image.setId(1);
		image.setName("MANJU");

		File file = new File("D:\\Documents\\Manju.jpeg");
		byte fileContent[] = new byte[(int) file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(fileContent);

		image.setData(fileContent);
		imageRepository.save(image);
		inputStream.close();
	}
	
	@Test
	public void testReadImage() {
		Image image = imageRepository.findById(1L).get();
		File file = new File("C:\\Users\\Mohit\\Downloads\\" + image.getName());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(image.getData());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
