package com.example.workshopmovieapps.data

import android.content.Context
import androidx.annotation.DrawableRes
import com.example.workshopmovieapps.R

data class Voucher(
    @DrawableRes
    val img:Int
)

fun getVoucherList(context: Context):List<Voucher>{
    val listVoucher = mutableListOf<Voucher>()
    listVoucher.clear()
    listVoucher.add(
        Voucher(
            R.drawable.img_voucher1
        )
    )
    listVoucher.add(
        Voucher(
            R.drawable.img_voucher1
        )
    )
    listVoucher.add(
        Voucher(
            R.drawable.img_voucher1
        )
    )
    listVoucher.add(
        Voucher(
            R.drawable.img_voucher1
        )
    )
    listVoucher.add(
        Voucher(
            R.drawable.img_voucher1
        )
    )
    return listVoucher
}