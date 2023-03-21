package com.URLvalidation.Validation.validator.Model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table
public class Result {

    @Id
    private String resp_key;
    @Column(nullable = false)
    private Integer result_code;
    @Column(nullable = false)
    private String result;

    public Result() {
    }

    public Result(String resp_key, Integer result_code, String result) {
        this.resp_key = resp_key;
        this.result_code = result_code;
        this.result = result;
    }

    public String getResp_key() {
        return resp_key;
    }

    public void setResp_key(String resp_key) {
        this.resp_key = resp_key;
    }

    public Integer getResult_code() {
        return result_code;
    }

    public void setResult_code(Integer result_code) {
        this.result_code = result_code;
    }

    public void setNewResult(String param) {
        try {
            String ans = this.result;
            int i = ans.indexOf('<');
            int j = ans.indexOf('>');
            String st = ans.substring(0, i);
            String en = ans.substring(j + 1);
            ans = st + param + en;
            System.out.println("this is the one one ");
            System.out.println(ans);
            this.result = ans;
        }
        catch(Exception e) {

        }
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resp_key='" + resp_key + '\'' +
                ", result_code=" + result_code +
                ", result='" + result + '\'' +
                '}';
    }
}
