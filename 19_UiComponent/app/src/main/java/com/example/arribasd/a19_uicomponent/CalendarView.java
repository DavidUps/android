package com.example.arribasd.a19_uicomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by ArribasD on 2/12/2018.
 */

public class CalendarView extends LinearLayout {

    private Calendar currentDate = Calendar.getInstance();

    private static final int DAYS_COUNT = 42;

    private String dateFormat;

    //event handling
    private EventHandler eventHandler = null;

    //Componetes Internos
    private LinearLayout header;
    private ImageView    btnPrev;
    private ImageView    btnNext;
    private TextView     txtDate;
    private GridView     grid;

    //Color estaciones
    int[] rainbow = new int[]{
            R.color.summer,
            R.color.fall,
            R.color.winter,
            R.color.spring
    };

    int[] monthSeason = new int[]{2, 2, 3, 3, 3, 0, 0, 0, 1, 1, 1, 2};
    //Constructores
    public CalendarView(Context context) {
        super(context);
    }


    public CalendarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initControl(context, attrs);

    }

    public CalendarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //Cargar componentes XML layout
    private void initControl(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.control_calendar,this);

        //El layaout esta inflado, asignamos valores a las variables locales
        header = findViewById(R.id.calendar_header);
        btnPrev = findViewById(R.id.calendar_prev_button);
        btnNext = findViewById(R.id.calendar_next_button);
        txtDate = findViewById(R.id.calendar_date_display);
        grid = findViewById(R.id.calendar_grid);

        loadDateFormat(attrs);
        updateCalendar();
    }

    private void loadDateFormat(AttributeSet attrs) {

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.CalendarDateElement);

        dateFormat = ta.getString(R.styleable.CalendarDateElement_dateFormat);

    }

    public void updateCalendar() {
        updateCalendar(null);
    }

    public void updateCalendar(HashSet<Date> events) {
        ArrayList<Date> cells = new ArrayList<>();
        Calendar calendar = (Calendar)currentDate.clone();

        //Determina la celda por el comienzo del mes actual
        calendar.set(Calendar.DAY_OF_MONTH,1);
        int monthBeginningCell = calendar.get(Calendar.DAY_OF_WEEK)-1;

        //Mover calendario hacia comienzo de la semana
        calendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell);

        //Rellena celdas
        while(cells.size() < DAYS_COUNT){
            cells.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }

        //Actualizar la grid
        grid.setAdapter(new CalendarAdapter(getContext(), cells, events));

        //Actualizar titulo
        SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy");
        txtDate.setText(sdf.format(currentDate.getTime()));
    }

    private class CalendarAdapter extends ArrayAdapter<Date> {

        //Dias con eventos
        private HashSet<Date> eventDays;

        //Para la interacción con la vista
        private LayoutInflater inflater;

        public CalendarAdapter(Context context, ArrayList<Date> days, HashSet<Date> eventDays) {
            super(context, R.layout.control_calendar_day, days);
            this.eventDays = eventDays;
            inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
            //Dia en cuestion
            Date date = getItem(position);
            int day = date.getDate();
            int month = date.getMonth();
            int year = date.getYear();

            //Hoy
            Date today = new Date();

            //inflar el item si no existe ya
            if (view == null)
                view = inflater.inflate(R.layout.control_calendar_day, parent, false);

            //si tiene un evento se pone la imagen
            view.setBackgroundResource(0);
            if (eventDays != null) {
                for (Date eventDate : eventDays) {
                    if (eventDate.getDate() == day && eventDate.getMonth() == month && eventDate.getYear() == year) {
                        //Marcamos ese dia con un evento
                        view.setBackgroundResource(R.drawable.reminder);
                        break;
                    }
                }
            }
            //Estilo claro
            ((TextView) view).setTypeface(null, Typeface.NORMAL);
            ((TextView) view).setTextColor(Color.BLACK);

            if (date.getMonth() != today.getMonth() || date.getYear() != today.getYear()) {
                //Si el dia esta fuera del mes esta fuera se pone en gris
                ((TextView) view).setTextColor(getResources().getColor(R.color.greyed_out));
            } else if (date.getDate() == today.getDate()) {
                //Si es el dia de hoy, poner en azul negrita
                ((TextView) view).setTypeface(null, Typeface.BOLD);
                ((TextView) view).setTextColor(getResources().getColor(R.color.today));
            }

            //Poner texto
            ((TextView) view).setText(String.valueOf(date.getDate()));
            return view;

        }

        public void updateData(ArrayList<Date> cells) {
            //Ponemos el color en la cabecera
            int month = currentDate.get(Calendar.MONTH);
            int season = monthSeason[month];
            int color = rainbow[season];

            header.setBackgroundColor(getResources().getColor(color));
        }
    }
    private void assignClickHandlers(){

        btnNext.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                currentDate.add(Calendar.MONTH, 1);
                updateCalendar();
            }
        });

        // subtract one month and refresh UI
        btnPrev.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                currentDate.add(Calendar.MONTH, -1);
                updateCalendar();
            }
        });

        grid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (eventHandler == null)
                    return false;

                eventHandler.onDayLongPress((Date) parent.getItemAtPosition(position));

                return true;
            }
        });

    }

    public void setEventHandler(EventHandler eventHandler)
    {
        this.eventHandler = eventHandler;
    }

    public interface EventHandler
    {
        void onDayLongPress(Date date);
    }

}
