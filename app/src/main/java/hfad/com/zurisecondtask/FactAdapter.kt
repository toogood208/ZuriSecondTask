package hfad.com.zurisecondtask

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

/*
Create an array adapter pass in dataset as the type
 */
class FactAdapter(context:Context,facts: List<FactModel>):ArrayAdapter<FactModel>(context,0,facts) {

    // get view method help us to display the listview
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val fact = getItem(position)

        // get view when there is something to display i.e when view is notnull
        if (view == null){
            // inflate the listitem layout to screen
            view = LayoutInflater.from(parent.context).inflate(R.layout.facts_item,parent,false)
        }

        // grab the views
        val logo = view?.findViewById<ImageView>(R.id.image_logo)
        val name = view?.findViewById<TextView>(R.id.name_tv)

        // set the values
        fact?.logo?.let { logo?.setImageResource(fact.logo) }
        name?.text = fact?.name

        // for detailview when you click
        view?.setOnClickListener {
            val intent = Intent(parent.context, FactDetail::class.java)
            intent.putExtra(LOGO_EXTRA, fact?.logo)
            intent.putExtra(NAME_EXTRA, fact?.name)
            intent.putExtra(FACT_EXTRA, fact?.fact)

            // start the intent
            parent.context.startActivity(intent)
        }

        // only use when yiu are sure there is not null
        return view!!
    }

    // this is to pass extra messages via intent
    companion object{
        val LOGO_EXTRA = "logo_extras"
        val NAME_EXTRA = "name_extras"
        val FACT_EXTRA = "fact_extras"
    }
}