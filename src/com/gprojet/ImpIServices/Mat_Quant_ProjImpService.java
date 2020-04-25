package com.gprojet.ImpIServices;

import java.util.List;

import com.gprojet.IServices.IServiceMat_Quant_Proj;
import com.gprojet.dao.IDAOMat_Quant_Proj;
import com.gprojet.entities.Mat_Quant_Proj;
import com.gprojet.impdao.DaoImpMat_Quant_Proj;



public class Mat_Quant_ProjImpService implements IServiceMat_Quant_Proj{

	
	  IDAOMat_Quant_Proj dao =  new DaoImpMat_Quant_Proj();
	  
@Override
public List<Mat_Quant_Proj> getAll() throws Exception {
	
	return dao.getAll();
}



@Override
public boolean save(Mat_Quant_Proj obj) {
	
	return dao.save(obj);
}

@Override
public boolean update(Mat_Quant_Proj obj) {
	
	return dao.update(obj);
}



@Override
public Mat_Quant_Proj getOne(String nom) {
	// TODO Auto-generated method stub
	return null;
}




@Override
public boolean delete(Mat_Quant_Proj obj) {
	// TODO Auto-generated method stub
	return false;
}



@Override
public Mat_Quant_Proj FindById(int id) {
	// TODO Auto-generated method stub
	return null;
}

}
