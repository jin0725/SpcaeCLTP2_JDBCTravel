package com.space.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.space.global.*;
import com.space.travel.Food;
import com.space.travel.Lodging;

public class TravelUpdateService implements Start {

    @Override
    public void start() {
        while(true) {
            AppUI.TravelUpdateScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:                //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.updateTravelPackage:      //여행패키지 추가
                    UpdateTravel();
                    break;
                case GlobalParams.updateTravelPlace:        //여행지 추가
                    UpdatePlace();
                    break;
                case GlobalParams.updateTravelLodging:      //숙박시설 추가
                    UpdateLodging();
                    break;
                case GlobalParams.updateTravelFood:         //음식 추가
                    UpdateFood();
                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }

    private boolean UpdateFood() {
    	Food food = new Food();
    	
    	boolean result = false;
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE FOODS SET FOOD_NAME = ? WHERE FOOD_NO = ?")){ 
    			
			pStatement.setString(1, food.getFoodName());
			pStatement.setInt(2, food.getFoodNumber());
			
			
			int rows = pStatement.executeUpdate(); 
			
			if (rows > 0) {
				result = true;
			}
    			
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
		return result; 
    }


    private boolean UpdateLodging() {
    	Lodging lodging = new Lodging();
    	
    	boolean result = false;
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE LODGINGS SET LODGING_NAME = ? WHERE LODGING_NO = ?")){ 
    			
			pStatement.setString(1, lodging.getLodgingName());
			pStatement.setInt(2, lodging.getLodgingNumber());
			
			
			int rows = pStatement.executeUpdate(); 
			
			if (rows > 0) {
				result = true;
			}
    			
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
		return result; 

    }

    private void UpdatePlace() {

    }

    private void UpdateTravel() {

    }
}
