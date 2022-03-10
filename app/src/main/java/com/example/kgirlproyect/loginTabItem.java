package com.example.kgirlproyect;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class loginTabItem extends Fragment {

    private EditText email,pass;
    private Button enviarLogin;
    ConMysql conexion;

    protected float v=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_login_tab_item,container,false);
        email = root.findViewById(R.id.edtEmail);
        pass = root.findViewById(R.id.edtPass);
        enviarLogin = root.findViewById(R.id.btnIniciar);
        conexion = new ConMysql();

        email.setAlpha(v);
        pass.setAlpha(v);
        enviarLogin.setAlpha(v);

        enviarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Verificacion verificacion = new Verificacion();
                verificacion.execute("");
            }
        });

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        enviarLogin.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        return root;
    }

    public class Verificacion extends AsyncTask<String,String,String> {

        Boolean exito = false;
        String mensaje ="";
        String Correo = email.getText().toString();
        String Contraseña = pass.getText().toString();

        @Override
        protected void onPreExecute(){

        }
        @Override
        protected void onPostExecute(String msj){

            //Intent que llevara al menu cuando este funcionando
            Toast.makeText(getContext(),msj,Toast.LENGTH_LONG).show();
            if(exito){
                Intent i = new Intent(getActivity(),Menu.class);
                startActivity(i);
            }
            else {

            }
        }


        @Override
        protected String doInBackground(String... strings) {
            Connection con = conexion.Conectar();
            if(con!= null){
                String query = "Select * From usuario where email=? and contraseña=?";

                try {
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1,Correo);
                    ps.setString(2,Contraseña);

                    ResultSet rs = ps.executeQuery();

                    if(rs.next()){
                        exito = true;
                        mensaje = "Bienvenid@ "+rs.getString(2);
                    }
                    else{
                        mensaje ="Usuario o Contraseña Incorrecto";
                    }

                }
                catch (SQLException e){
                    e.printStackTrace();
                }

                try {
                    con.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            else {
                mensaje = "No hay conexión a la base de datos";
            }

            return mensaje;

        }
    }

}