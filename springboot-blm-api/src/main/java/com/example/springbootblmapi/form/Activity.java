package com.example.springbootblmapi.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Activity {
    int activityId;
    Double activityCondition;
    Double activityReduce;
    Integer isActive;
}
