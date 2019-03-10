from django.contrib import admin
from django.urls import path, include
from . import views

app_name = 'paul'
urlpatterns = [
    path('detailman/', views.detail, name='detail'),
]
