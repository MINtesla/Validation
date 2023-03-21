package com.URLvalidation.Validation.validator.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


@Entity
@Table
public class Validate {

        @Id
        private String param_name ;
        @Column(nullable = false)
        private Integer is_mandatory;
        @Column(nullable = false)
        private String datatype;
        private Integer min_length;
        private Integer max_length ;
        private String regex ;


        public Validate() {
        }

    public Validate(String param_name, Integer is_mandatory, String datatype, Integer min_length, Integer max_length, String regex) {
        this.param_name = param_name;
        this.is_mandatory = is_mandatory;
        this.datatype = datatype;
        this.min_length = min_length;
        this.max_length = max_length;
        this.regex = regex;
    }

    public String getParam_name() {
        return param_name;
    }

    public void setParam_name(String param_name) {
        this.param_name = param_name;
    }

    public Integer getIs_mandatory() {
        return is_mandatory;
    }

    public void setIs_mandatory(Integer is_mandatory) {
        this.is_mandatory = is_mandatory;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public Integer getMin_length() {
        return min_length;
    }

    public void setMin_length(Integer min_length) {
        this.min_length = min_length;
    }

    public Integer getMax_length() {
        return max_length;
    }

    public void setMax_length(Integer max_length) {
        this.max_length = max_length;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return "Validate{" +
                "param_name='" + param_name + '\'' +
                ", is_mandatory=" + is_mandatory +
                ", datatype='" + datatype + '\'' +
                ", min_length=" + min_length +
                ", max_length=" + max_length +
                ", regex='" + regex + '\'' +
                '}';
    }
}
