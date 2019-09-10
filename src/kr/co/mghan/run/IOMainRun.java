package kr.co.mghan.run;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// 자료 입출력
public class IOMainRun
{
	public static void main(String[] args)
	{
		// 파일생성
		File file = new File("c:/lab/workspace for java.zip");
		File file2 = new File("c:/Test/workspace for java3.zip");

		if (!file.exists())
		{
			// 파일이 없으면 파일 생성
			try
			{
				System.out.println("file을 생성합니다.");
				file.createNewFile();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!file2.exists())
		{
			try
			{
				System.out.println("file2를 생성합니다.");
				file2.createNewFile();
			}
			catch (Exception e)
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		// 외부 파일 값 받아오기
		FileInputStream fis = null;
		// 외부 파일에 값 전달하기
		FileOutputStream fos = null;

		try
		{
			fis = new FileInputStream(file);
			fos = new FileOutputStream(file2);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int data = 0;
		byte[] readBytes = new byte[10];
		try
		{
			while ((data = fis.read(readBytes)) != -1)
			{
				System.out.write(data);
				fos.write(readBytes, 0, data);

			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fos.flush(); // 기록 후 메모리를 비움
				fos.close();
				fis.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
