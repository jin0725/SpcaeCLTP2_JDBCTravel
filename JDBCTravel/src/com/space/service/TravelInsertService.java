package com.space.service;

import com.space.global.*;

public class TravelInsertService implements Start {

    @Override
    public void start() {
        while(true) {
            AppUI.TravelInsertScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:                //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.insertTravelPackage:      //여행패키지 추가
                    InsertTravel();
                    break;
                case GlobalParams.insertTravelPlace:        //여행지 추가
                    InsertPlace();
                    break;
                case GlobalParams.insertTravelLodging:      //숙박시설 추가
                    InsertLodging();
                    break;
                case GlobalParams.insertTravelFood:         //음식 추가
                    InsertFood();
                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }

    private void InsertFood() {
    }

    private void InsertLodging() {
    }

    private void InsertPlace() {
    }

    private void InsertTravel() {
    }
}
