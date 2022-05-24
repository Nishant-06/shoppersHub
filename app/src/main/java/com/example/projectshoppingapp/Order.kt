package com.example.projectshoppingapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectshoppingapp.data.RecyclerViewOrdersAdapter
import com.example.projectshoppingapp.model.ApiInterface
import com.example.projectshoppingapp.model.OrdersData
import com.example.projectshoppingapp.model.Products
import com.example.projectshoppingapp.model.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Order : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val root = inflater.inflate(R.layout.fragment_orders, container, false)
        val retrofit = ServiceBuilder.buildService(ApiInterface::class.java)

        retrofit.getProducts().enqueue(
            object : Callback<OrdersData> {
                override fun onFailure(call: Call<OrdersData>, t: Throwable) {
                    Log.d("Error", "error:  : $t)}")
                }
                override fun onResponse(call: Call<OrdersData>, response: Response<OrdersData>) {
                    if (response.body() != null) {
                        val ordersList = response.body()!!.data.toList()
                        val products: MutableList<Products> = mutableListOf()
//                        var orderDate: String
                        ordersList.forEach {order ->
//                            orderDate = order.orderDate
                            order.data.forEach {
//                                it.expiryDate = orderDate
                                products.add(it)
                            }
                        }
                        val recycleView = root.findViewById<RecyclerView>(R.id.recyclerView3)

                        val adapter = RecyclerViewOrdersAdapter(products)
                        recycleView.adapter = adapter
                        recycleView.layoutManager = LinearLayoutManager(requireActivity())
                    }

                }
            }
        )
//        retrofit.getProducts().enqueue(
//            object : Callback<OrdersData> {
//
//                override fun onFailure(call: Call<OrdersData>, t: Throwable) {
//                    Log.d("Error", "error:  : $t)}")
//                }
//
//                override fun onResponse(call: Call<OrdersData>, response: Response<OrdersData>) {
//                    if (response.body() != null) {
//                        Log.d("Response", response.body()?.itemName.toString())
//                        Log.d("Response", response.body()?.desc.toString())
//                        Log.d("Response", response.body()?.price.toString())
//                        Log.d("Response", response.body()?.currency.toString())
//                        Log.d("Response", response.body()?.expiryDate.toString())
//                        Log.d("Response", response.body()?.quantity.toString())
////                        products = response.body()!!.data.toList()
////                        val recycleView = binding.recycleView
////                        val adapter = ProductsAdapter(products)
////                        recycleView.adapter = adapter
////                        recycleView.layoutManager = LinearLayoutManager(requireActivity())
//
//                    }
//                }
//            }
//        )
//        val repository = Repository()
//        val viewModelFactory = MainViewModelFactory(repository)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
//        viewModel.getPost()
//        viewModel.myResponse.observe(viewLifecycleOwner, Observer {
//            response ->
//            if (response.isSuccessful) {
//                Log.d("Response", response.body()?.itemName.toString())
//                Log.d("Response", response.body()?.desc.toString())
//                Log.d("Response", response.body()?.price.toString())
//                Log.d("Response", response.body()?.currency.toString())
//                Log.d("Response", response.body()?.expiryDate.toString())
//                Log.d("Response", response.body()?.quantity.toString())
//
//            }
//            else
//                Log.d("Response", response.errorBody().toString())
//        })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        var rf = Retrofit.Builder()
//            .baseUrl(RetrofitInterface.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        var API = rf.create(RetrofitInterface::class.java)
//        var call = API.posts
//        call?.enqueue(object : Callback<List<PostModel?>?>{
//            override fun onResponse(
//                call: Call<List<PostModel?>?>,
//                response: Response<List<PostModel?>?>
//            ) {
//              var postlist :List<PostModel>? = response.body() as List<PostModel>
//                var post = arrayOfNulls<String>(postlist!!.size)
//
//                for ( i in postlist!!.indices) {
//                    post[i] = postlist!![i]!!.userId.toString()
//                }
//
//                var adapter = ArrayAdapter<String>(requireActivity(), android.R.layout.simple_dropdown_item_1line,post)
//                listView.adapter = adapter
//            }
//
//            override fun onFailure(call: Call<List<PostModel?>?>, t: Throwable) {
//
//            }
//
//        })
//    }



    }
}