package com.example.kgirlproyect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class loginTabItem extends Fragment {

    private EditText email,pass;
    private Button enviarLogin;
    protected float v=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_login_tab_item,container,false);

        email = root.findViewById(R.id.edtEmail);
        pass = root.findViewById(R.id.edtPass);
        enviarLogin = root.findViewById(R.id.btnIniciar);

        email.setAlpha(v);
        pass.setAlpha(v);
        enviarLogin.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        enviarLogin.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        return root;
    }
    
}