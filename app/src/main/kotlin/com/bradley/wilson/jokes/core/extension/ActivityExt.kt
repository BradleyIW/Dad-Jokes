package com.bradley.wilson.jokes.core.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

inline fun AppCompatActivity.fragmentTransaction(
    func: FragmentTransaction.() -> FragmentTransaction
) {
    supportFragmentManager.beginTransaction().func().commit()
}