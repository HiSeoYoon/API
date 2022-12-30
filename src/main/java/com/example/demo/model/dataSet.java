package com.example.demo.model;

import lombok.Data;

@Data
public class dataSet {
        private int 		camId;
        private String		camName;

        public dataSet(){
            camId = 0;
            camName = "";
        }

}
