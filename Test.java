package Java1;
import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


import java.util.*;
public class Test {
    
    public static void main(String[] args){
    	SinhVien sv = new SinhVien();
    	MonHoc mh = new MonHoc();
    	GiangVien gv = new GiangVien();
    	String fileName = "C:\\Users\\root\\Desktop\\java1\\data-input\\input2.dat";
    	int []i ={0};//i là biến đếm xem chúng ta đã in tới dòng nào
    	ArrayList list = new ArrayList();
    	ArrayList svTKB = sv.getSvTKB();
    	ArrayList gvTKB = gv.getGvTKB();
    	try(Stream<String> stream = Files.lines(Paths.get(fileName),StandardCharsets.UTF_8)){
    	//đưa về dạng chuẩn utf8
    		stream.forEach(line ->{
    			//System.out.println(line); //đọc file theo từng dòng
    			StringTokenizer chiaDong = new StringTokenizer(line);
    			while(chiaDong.hasMoreTokens()) {
    				String listMSSV="";
    				listMSSV=chiaDong.nextToken(",");
    				StringTokenizer b = new StringTokenizer(listMSSV);
    				while(b.hasMoreTokens()) {
        				String listMSSV1="";
        				listMSSV1=b.nextToken("	");
        				list.add(listMSSV1);
    			}
    			}
    			});
    	}catch (Exception e) {
    		//e.printStackTrace();
    	} 
    	//System.out.println(list); //cho vào arrlist
    	String d = list.get(0).toString();
    	String e = list.get(1).toString();
    	String f = list.get(2).toString();
    	list.remove(0);
    	list.remove(0);
    	list.remove(0);
    	//System.out.println(list); //bỏ ra 3 tham số của câu d, e ,f.
    	ArrayList listIDGV = new ArrayList();//danh sách mã số giảng viên , họ tên, giới tính của giảng viên.
    	ArrayList listIDSV = new ArrayList();//danh sách mã số sinh viên, họ tên, giới tính của sinh viên.
    	ArrayList listIDSVNONAME = new ArrayList();//danh sách chỉ có id của sinh viên.
    	ArrayList listIDGVNONAME = new ArrayList();//danh sách chỉ có id của giảng viên.
    	ArrayList listMH = new ArrayList();//danh sách mã môn học và số tính chỉ của môn đó.
    	for(int x=0;x<list.size();x++) {    		
    		if("#SinhVien".equals(list.get(x)) == true) {
    			listIDSV.add(list.get(x+1));
    			sv.id = list.get(x+1).toString();
    			listIDSVNONAME.add(list.get(x+1));
    			listIDSV.add(list.get(x+2));
    			sv.name = list.get(x+2).toString();
    			listIDSV.add(list.get(x+3));
    			listIDSV.add("0");
    			if("M".equals(list.get(x+3)) == true) {
    				sv.gender = 'M';
    			}else {
    				sv.gender = 'F';
    			}
    			//System.out.println(sv.name);
    	    	//System.out.println(sv.id);
    			//System.out.println(listIDSV);
    			//System.out.println(sv.gender);
    		}
    		else if("#GiangVien".equals(list.get(x)) == true) {
    			listIDGV.add(list.get(x+1));
    			listIDGV.add(list.get(x+2));
    			listIDGV.add(list.get(x+3));
    			listIDGV.add("0");
    			listIDGVNONAME.add(list.get(x+1));
    			gv.id = list.get(x+1).toString();
    			gv.name = list.get(x+2).toString();
    			if("M".equals(list.get(x+3)) == true) {
    				sv.gender = 'M';
    			}else {
    				sv.gender = 'F';
    			}
//    			System.out.println(gv.id);
//    	    	System.out.println(gv.name);
//    			System.out.println(gv.gender);
    		}
    		else if("#MonHoc".equals(list.get(x)) == true) {
    			listMH.add(list.get(x+1));
    			listMH.add(list.get(x+2));
    			listMH.add(list.get(x+3));
    			String mmh = mh.getMaMH();
    			mmh = list.get(x+1).toString();
    			String tmh = mh.getTenMH();
    			tmh = list.get(x+2).toString();
    			int tc = mh.getTinChi();
    			if("1".equals(list.get(x+3)) == true) {
    				 tc = 1;
    			}
    			else if("2".equals(list.get(x+3)) == true) {
   				 	 tc = 2;
    			}
    			else if("3".equals(list.get(x+3)) == true) {
  				 	 tc = 3;
    			}
    			else if("4".equals(list.get(x+3)) == true) {
 				 	 tc = 4;
    			}
    			else {
    				tc = 5;
    			}
//    			System.out.println(mmh);
//    			System.out.println(tmh);
//    			System.out.println(tc);
    		}
    		else if("#svTKB".equals(list.get(x)) == true) {
    			svTKB.add(list.get(x+1));
    			svTKB.add(list.get(x+2));
    		}
    		else if("#gvTKB".equals(list.get(x)) == true) {
    			gvTKB.add(list.get(x+1));
    			gvTKB.add(list.get(x+2));
    		}
    		//System.out.println(sv.id);
    	}

    	System.out.println(gvTKB);
    	System.out.println(listIDGV);
    	System.out.println(listIDSV);
    	System.out.println(svTKB);
    	System.out.println(listMH);
    	//---------------------------------------------------------------------------------------------------------------------------------------------   	
    	//tính số tính chỉ và in ra danh sach sinh vien.
    	int stcID = sv.getSoTinChiTichLuy();
    	for(int q=0;q<listIDSV.size();q++) {
    		for(int w=0;w<svTKB.size();w++) {
    			for(int r = 0;r<listMH.size();r++) {
    				if(listIDSV.get(q).equals(svTKB.get(w)) == true) {
//    					listSVMH.add(listIDSV.get(q));
//    					listSVMH.add(svTKB.get(w));					
    					if(svTKB.get(w+1).equals(listMH.get(r)) == true && "3".equals(listMH.get(r+2)) == true) {
    						stcID = stcID+3;	
    						listIDSV.set(q+3, stcID);
    					}
    					else if(svTKB.get(w+1).equals(listMH.get(r)) == true && "4".equals(listMH.get(r+2)) == true) {
    						stcID = stcID+4;
    						listIDSV.set(q+3, stcID);
    					}
    					else if(svTKB.get(w+1).equals(listMH.get(r)) == true && "1".equals(listMH.get(r+2)) == true) {
    						stcID = stcID+1;
    						listIDSV.set(q+3, stcID);
    					}
    					else if(svTKB.get(w+1).equals(listMH.get(r)) == true && "2".equals(listMH.get(r+2)) == true) {
    						stcID = stcID+2;
    						listIDSV.set(q+3, stcID);
    					}
    					else if(svTKB.get(w+1).equals(listMH.get(r)) == true && "5".equals(listMH.get(r+2)) == true) {
    						stcID = stcID+5;
    						listIDSV.set(q+3, stcID);
    					}
    					//System.out.println(listSVMH);    					    						
    				}
    		}//System.out.println(stcID);
    	}stcID = 0;
    	}
   //	System.out.println(listIDSV);
//    	System.out.println(listIDSVNONAME);
    	String caub = "";
    	for(int a = 0;a<listIDSV.size();a++) {
    		for(int b =0;b<listIDSVNONAME.size();b++) {
    			if(listIDSV.get(a).equals(listIDSVNONAME.get(b)) == true ) {
    				caub += listIDSV.get(a).toString()+","+listIDSV.get(a+1).toString()+","+listIDSV.get(a+2).toString()+","+listIDSV.get(a+3).toString()+"\n";
    			}
    		}
    	}
    	//System.out.println(caub);
    	try {
			   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
			   FileOutputStream fos = new FileOutputStream("C:\\Users\\root\\Desktop\\java1\\students.dat");
			   DataOutputStream dos = new DataOutputStream(fos);

			   //Bước 2: Ghi dữ liệu
			   dos.writeBytes(caub);
			   //Bước 3: Đóng luồng
			   fos.close();
			   dos.close();
			  } catch (IOException ex) {
			    ex.printStackTrace();
			  } 
    	//--------------------------------------------------------------------------------------------------------------------------------------------
    	//tính số môn của giảng viên dạy và in ra danh sách giảng viên.
//    	System.out.println(listIDGV);
//    	System.out.println(gvTKB);
//    	System.out.println(svTKB);
    	int sld = gv.getSoLopGiangDay();
    	for(int a = 0;a<listIDGV.size();a++) {
    		for(int b = 0;b<gvTKB.size();b++) {
    				if(listIDGV.get(a).equals(gvTKB.get(b)) == true) {
    						sld++;
    						listIDGV.set(a+3, sld);
    				}
    			}sld=0;
    		}
    	//System.out.println(listIDGV);
    	//im ra giảng viên
//    	System.out.println(listIDGV);
//    	System.out.println(listIDGVNONAME);
    	String cauc = "";
    	for(int a = 0;a<listIDGV.size();a++) {
    		for(int b =0;b<listIDGVNONAME.size();b++) {
    			if(listIDGV.get(a).equals(listIDGVNONAME.get(b)) == true ) {
    				cauc += listIDGV.get(a).toString()+","+listIDGV.get(a+1).toString()+","+listIDGV.get(a+2).toString()+","+listIDGV.get(a+3).toString()+"\n";
    			}
    		}
    	}
    	try {
			   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
			   FileOutputStream fos = new FileOutputStream("C:\\Users\\root\\Desktop\\java1\\teachers.dat");
			   DataOutputStream dos = new DataOutputStream(fos);

			   //Bước 2: Ghi dữ liệu
			   dos.writeBytes(cauc);
			   //Bước 3: Đóng luồng
			   fos.close();
			   dos.close();
			  } catch (IOException ex) {
			    ex.printStackTrace();
			  } 
    	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
    	//câu d: Tìm những môn hoc mà sinh viên theo học.
//    	System.out.println(listMH);
//    	System.out.println(svTKB);
    	ArrayList DSMH = new ArrayList();
    	for(int a=0;a<svTKB.size();a++) {
    		if(d.equals(svTKB.get(a)) == true) {
    			DSMH.add(svTKB.get(a+1));
    		}
    	}
    	//System.out.println(DSMH);
    	String caud = "";
    	for(int b=0;b<listMH.size();b++) {
    		for(int c=0;c<DSMH.size();c++) {
    			if(DSMH.get(c).equals(listMH.get(b)) == true) {
    				caud += listMH.get(b)+","+listMH.get(b+1)+","+listMH.get(b+2)+"\n";
    			}
    		}
    	}
    	try {
			   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
			   FileOutputStream fos = new FileOutputStream("C:\\Users\\root\\Desktop\\java1\\4d.dat");
			   DataOutputStream dos = new DataOutputStream(fos);

			   //Bước 2: Ghi dữ liệu
			   dos.writeBytes(caud);
			   //Bước 3: Đóng luồng
			   fos.close();
			   dos.close();
			  } catch (IOException ex) {
			    ex.printStackTrace();
			  } 
    	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
    	//câu e: Tìm những môn học mà một sinh viên theo học, tham số đầu vào là MSSV
//    	System.out.println(svTKB);
//    	System.out.println(e);
    	ArrayList DSSV = new ArrayList();
    	for(int a=0;a<svTKB.size();a++) {
    		if(e.equals(svTKB.get(a)) == true) {
    			DSSV.add(svTKB.get(a-1));
    		}
    	}
    	//System.out.println(DSSV);
    	String caue = "";
    	for(int b=0;b<listIDSV.size();b++) {
    		for(int c=0;c<DSSV.size();c++) {
    			if(listIDSV.get(b).equals(DSSV.get(c)) == true) {   				
    				caue += listIDSV.get(b)+","+listIDSV.get(b+1)+","+listIDSV.get(b+2)+"\n";
    			}
    		}
    	}
    	//System.out.println(caue);
    	try {
			   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
			   FileOutputStream fos = new FileOutputStream("C:\\Users\\root\\Desktop\\java1\\4e.dat");
			   DataOutputStream dos = new DataOutputStream(fos);

			   //Bước 2: Ghi dữ liệu
			   dos.writeBytes(caue+"\n");
			   //Bước 3: Đóng luồng
			   fos.close();
			   dos.close();
			  } catch (IOException ex) {
			    ex.printStackTrace();
			  }
    	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
    	//Câu f: trả vể danh sách môn học của một giảng viên tham số đầu vào là MaGV.
//    	System.out.println(f);
//    	System.out.println(gvTKB);
//    	System.out.println(listMH);
    	ArrayList DSGV = new ArrayList();
    	for(int a=0;a<gvTKB.size();a++) {
    		if(f.equals(gvTKB.get(a)) == true) {
    			DSGV.add(gvTKB.get(a+1));
    		}
    	}
    	//System.out.println(DSGV);
    	String cauf = "";
    	for(int b=0;b<listMH.size();b++) {
    		for(int c=0;c<DSGV.size();c++) {
    			if(listMH.get(b).equals(DSGV.get(c)) == true) { 
    				cauf += listMH.get(b)+","+listMH.get(b+1)+","+listMH.get(b+2)+"\n";
    			}
    		}
    	}
		try {
			   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
			   FileOutputStream fos = new FileOutputStream("C:\\Users\\root\\Desktop\\java1\\4f.dat");
			   DataOutputStream dos = new DataOutputStream(fos);

			   //Bước 2: Ghi dữ liệu
			   dos.writeBytes(cauf);
			   //Bước 3: Đóng luồng
			   fos.close();
			   dos.close();
			  } catch (IOException ex) {
			    ex.printStackTrace();
			  } 
    	//----------------------------------------------------------------------------------------------------------------------------------------------------------------
    }
}


