package com.example.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.DAO.HoaDonChiTietDAO;
import com.example.myapplication.Dulieu.HoaDonChiTiet;
import com.example.myapplication.R;

import java.util.List;

public class HoadonchitietAdapter  extends BaseAdapter {
    List<HoaDonChiTiet> arrHoaDonChiTiet;
    public Activity context;
    public LayoutInflater inflater;
    HoaDonChiTietDAO hoaDonChiTietDAO;
    public HoadonchitietAdapter(Activity context, List<HoaDonChiTiet> arrayHoaDonChiTiet) {
        super();
        this.context = context;
        this.arrHoaDonChiTiet = arrayHoaDonChiTiet;
        this.inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        hoaDonChiTietDAO = new HoaDonChiTietDAO(context);
    }
    @Override
    public int getCount() {
        return arrHoaDonChiTiet.size();
    }
    @Override
    public Object getItem(int position) {
        return arrHoaDonChiTiet.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static class ViewHolder {
        TextView txtMaSach;
        TextView txtSoLuong;
        TextView txtGiaBia;
        TextView txtThanhTien;
        ImageView imgDelete;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.hoadonchitietitem, null);
            holder.txtMaSach =  convertView.findViewById(R.id.tvMaSach);
            holder.txtSoLuong =  convertView.findViewById(R.id.tvSoLuong);
            holder.txtGiaBia =  convertView.findViewById(R.id.tvGiaBia);
            holder.txtThanhTien = convertView.findViewById(R.id.tvThanhTien);
            holder.imgDelete = convertView.findViewById(R.id.ivDelete);
            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    hoaDonChiTietDAO.deleteHoaDonChiTietByID(String.valueOf(arrHoaDonChiTiet.get(position).getMaHDCT()));
                    arrHoaDonChiTiet.remove(position);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();
        HoaDonChiTiet _entry = (HoaDonChiTiet) arrHoaDonChiTiet.get(position);
        holder.txtMaSach.setText("Mã sách: "+_entry.getSach().getMaSach());
        holder.txtSoLuong.setText("Số lượng: "+_entry.getSoLuongMua());
        holder.txtGiaBia.setText("Giá bìa: "+_entry.getSach().getGiaBia() +" vnd");
        holder.txtThanhTien.setText("Thành tiền: "+_entry.getSoLuongMua()*_entry.getSach().getGiaBia()+" vnd");
        return convertView;
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
    public void changeDataset(List<HoaDonChiTiet> items){
        this.arrHoaDonChiTiet = items;
        notifyDataSetChanged();
    }
}
