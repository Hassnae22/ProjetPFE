package com.gprojet.IServices;

import java.util.List;

import com.gprojet.entities.Mat_Quant_Proj;

public interface IServiceMat_Quant_Proj{
   
List<Mat_Quant_Proj> getAll() throws Exception;
	
Mat_Quant_Proj FindById(int id);

Mat_Quant_Proj getOne(String nom);
	
	boolean save(Mat_Quant_Proj obj);
	
	boolean update(Mat_Quant_Proj obj);
	
	boolean delete(Mat_Quant_Proj obj);

}
