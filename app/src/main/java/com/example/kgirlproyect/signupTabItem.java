package com.example.kgirlproyect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class signupTabItem extends Fragment {
    private EditText correo,contra,name;
    private Button btnRegistro;
    private float v=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_signup_tab_item, container, false);
        name =root.findViewById(R.id.edtName);
        correo = root.findViewById(R.id.edtCorreo);
        contra = root.findViewById(R.id.edtContra);
        btnRegistro = root.findViewById(R.id.btnRegistrar);

        name.setAlpha(v);
        correo.setAlpha(v);
        contra.setAlpha(v);
        btnRegistro.setAlpha(v);

        name.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        correo.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        contra.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        btnRegistro.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        return root;
    }
}