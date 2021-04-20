package com.udacity.shoestore.shoesList

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.NewShoesObjectBinding
import com.udacity.shoestore.models.Shoe

class ShoesObjectCustomLayout: LinearLayout{
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val binding: NewShoesObjectBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.new_shoes_object, this, false)

    fun addShoes(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            tvName.text = shoe.name
            tvSize.text = shoe.size
            tvCompany.text = shoe.company
            tvDescription.text = shoe.description
        }
    }
}