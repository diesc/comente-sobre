/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.model;

/**
 *
 * @author Diego
 */
public class JsonResponse {

    private String status = null;
    private Object result = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
