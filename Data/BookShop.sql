PGDMP                         }            BookShop    13.20    13.20 L               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    58363    BookShop    DATABASE     Y   CREATE DATABASE "BookShop" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en-US';
    DROP DATABASE "BookShop";
                postgres    false            �            1259    58488    chi_tiet_hoa_don    TABLE     �   CREATE TABLE public.chi_tiet_hoa_don (
    ma_chitiet_hoa_don integer NOT NULL,
    ma_hoa_don integer,
    ma_sach integer,
    so_luong integer,
    thanh_tien numeric(38,2)
);
 $   DROP TABLE public.chi_tiet_hoa_don;
       public         heap    postgres    false            �            1259    58486 '   chi_tiet_hoa_don_ma_chitiet_hoa_don_seq    SEQUENCE     �   CREATE SEQUENCE public.chi_tiet_hoa_don_ma_chitiet_hoa_don_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 >   DROP SEQUENCE public.chi_tiet_hoa_don_ma_chitiet_hoa_don_seq;
       public          postgres    false    217                       0    0 '   chi_tiet_hoa_don_ma_chitiet_hoa_don_seq    SEQUENCE OWNED BY     s   ALTER SEQUENCE public.chi_tiet_hoa_don_ma_chitiet_hoa_don_seq OWNED BY public.chi_tiet_hoa_don.ma_chitiet_hoa_don;
          public          postgres    false    216            �            1259    58470    hoa_don    TABLE     �   CREATE TABLE public.hoa_don (
    ma_hoa_don integer NOT NULL,
    ma_khach_hang integer,
    ma_nhan_vien integer,
    ngay_lap_hoa_don timestamp without time zone
);
    DROP TABLE public.hoa_don;
       public         heap    postgres    false            �            1259    58468    hoa_don_ma_hoa_don_seq    SEQUENCE     �   CREATE SEQUENCE public.hoa_don_ma_hoa_don_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.hoa_don_ma_hoa_don_seq;
       public          postgres    false    215                       0    0    hoa_don_ma_hoa_don_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.hoa_don_ma_hoa_don_seq OWNED BY public.hoa_don.ma_hoa_don;
          public          postgres    false    214            �            1259    58412 
   khach_hang    TABLE     �   CREATE TABLE public.khach_hang (
    ma_khach_hang integer NOT NULL,
    ten_khach_hang character varying(255),
    so_dien_thoai integer,
    dia_chi character varying(255),
    ma_tai_khoan integer
);
    DROP TABLE public.khach_hang;
       public         heap    postgres    false            �            1259    58410    khach_hang_ma_khach_hang_seq    SEQUENCE     �   CREATE SEQUENCE public.khach_hang_ma_khach_hang_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.khach_hang_ma_khach_hang_seq;
       public          postgres    false    209                       0    0    khach_hang_ma_khach_hang_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.khach_hang_ma_khach_hang_seq OWNED BY public.khach_hang.ma_khach_hang;
          public          postgres    false    208            �            1259    58390    nha_xuat_ban    TABLE     �   CREATE TABLE public.nha_xuat_ban (
    ma_nha_xuat_ban integer NOT NULL,
    ten_nha_xuat_ban character varying(255),
    dia_chi character varying(255),
    email character varying(255)
);
     DROP TABLE public.nha_xuat_ban;
       public         heap    postgres    false            �            1259    58388     nha_xuat_ban_ma_nha_xuat_ban_seq    SEQUENCE     �   CREATE SEQUENCE public.nha_xuat_ban_ma_nha_xuat_ban_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.nha_xuat_ban_ma_nha_xuat_ban_seq;
       public          postgres    false    205                       0    0     nha_xuat_ban_ma_nha_xuat_ban_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.nha_xuat_ban_ma_nha_xuat_ban_seq OWNED BY public.nha_xuat_ban.ma_nha_xuat_ban;
          public          postgres    false    204            �            1259    58428 	   nhan_vien    TABLE     �   CREATE TABLE public.nhan_vien (
    ma_nhan_vien integer NOT NULL,
    ten_nhan_vien character varying(255),
    so_dien_thoai integer,
    dia_chi character varying(255),
    ma_tai_khoan integer
);
    DROP TABLE public.nhan_vien;
       public         heap    postgres    false            �            1259    58426    nhan_vien_ma_nhan_vien_seq    SEQUENCE     �   CREATE SEQUENCE public.nhan_vien_ma_nhan_vien_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.nhan_vien_ma_nhan_vien_seq;
       public          postgres    false    211                       0    0    nhan_vien_ma_nhan_vien_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.nhan_vien_ma_nhan_vien_seq OWNED BY public.nhan_vien.ma_nhan_vien;
          public          postgres    false    210            �            1259    58444    sach    TABLE     &  CREATE TABLE public.sach (
    ma_sach integer NOT NULL,
    ten_sach character varying(255),
    ma_tac_gia integer,
    ma_nha_xuat_ban integer,
    ma_the_loai integer,
    gia_ban numeric(38,2),
    so_luong integer,
    mo_ta character varying(255),
    hinh_anh character varying(255)
);
    DROP TABLE public.sach;
       public         heap    postgres    false            �            1259    58442    sach_ma_sach_seq    SEQUENCE     �   CREATE SEQUENCE public.sach_ma_sach_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.sach_ma_sach_seq;
       public          postgres    false    213                       0    0    sach_ma_sach_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.sach_ma_sach_seq OWNED BY public.sach.ma_sach;
          public          postgres    false    212            �            1259    58377    tac_gia    TABLE     �   CREATE TABLE public.tac_gia (
    ma_tac_gia integer NOT NULL,
    ten_tac_gia character varying(255),
    tieu_su character varying(255)
);
    DROP TABLE public.tac_gia;
       public         heap    postgres    false            �            1259    58375    tac_gia_ma_tac_gia_seq    SEQUENCE     �   CREATE SEQUENCE public.tac_gia_ma_tac_gia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.tac_gia_ma_tac_gia_seq;
       public          postgres    false    203                       0    0    tac_gia_ma_tac_gia_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.tac_gia_ma_tac_gia_seq OWNED BY public.tac_gia.ma_tac_gia;
          public          postgres    false    202            �            1259    58401 	   tai_khoan    TABLE       CREATE TABLE public.tai_khoan (
    ma_tai_khoan integer NOT NULL,
    ten_tai_khoan character varying(255),
    email character varying(255),
    mat_khau character varying(255),
    phan_quyen character varying(255),
    ten_nguoi_dung character varying(255)
);
    DROP TABLE public.tai_khoan;
       public         heap    postgres    false            �            1259    58399    tai_khoan_ma_tai_khoan_seq    SEQUENCE     �   CREATE SEQUENCE public.tai_khoan_ma_tai_khoan_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.tai_khoan_ma_tai_khoan_seq;
       public          postgres    false    207                       0    0    tai_khoan_ma_tai_khoan_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.tai_khoan_ma_tai_khoan_seq OWNED BY public.tai_khoan.ma_tai_khoan;
          public          postgres    false    206            �            1259    58366    the_loai    TABLE     �   CREATE TABLE public.the_loai (
    ma_the_loai integer NOT NULL,
    ten_the_loai character varying(255),
    mo_ta character varying(255)
);
    DROP TABLE public.the_loai;
       public         heap    postgres    false            �            1259    58364    the_loai_ma_the_loai_seq    SEQUENCE     �   CREATE SEQUENCE public.the_loai_ma_the_loai_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.the_loai_ma_the_loai_seq;
       public          postgres    false    201                       0    0    the_loai_ma_the_loai_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.the_loai_ma_the_loai_seq OWNED BY public.the_loai.ma_the_loai;
          public          postgres    false    200            a           2604    58491 #   chi_tiet_hoa_don ma_chitiet_hoa_don    DEFAULT     �   ALTER TABLE ONLY public.chi_tiet_hoa_don ALTER COLUMN ma_chitiet_hoa_don SET DEFAULT nextval('public.chi_tiet_hoa_don_ma_chitiet_hoa_don_seq'::regclass);
 R   ALTER TABLE public.chi_tiet_hoa_don ALTER COLUMN ma_chitiet_hoa_don DROP DEFAULT;
       public          postgres    false    217    216    217            `           2604    58473    hoa_don ma_hoa_don    DEFAULT     x   ALTER TABLE ONLY public.hoa_don ALTER COLUMN ma_hoa_don SET DEFAULT nextval('public.hoa_don_ma_hoa_don_seq'::regclass);
 A   ALTER TABLE public.hoa_don ALTER COLUMN ma_hoa_don DROP DEFAULT;
       public          postgres    false    214    215    215            ]           2604    58415    khach_hang ma_khach_hang    DEFAULT     �   ALTER TABLE ONLY public.khach_hang ALTER COLUMN ma_khach_hang SET DEFAULT nextval('public.khach_hang_ma_khach_hang_seq'::regclass);
 G   ALTER TABLE public.khach_hang ALTER COLUMN ma_khach_hang DROP DEFAULT;
       public          postgres    false    208    209    209            [           2604    58393    nha_xuat_ban ma_nha_xuat_ban    DEFAULT     �   ALTER TABLE ONLY public.nha_xuat_ban ALTER COLUMN ma_nha_xuat_ban SET DEFAULT nextval('public.nha_xuat_ban_ma_nha_xuat_ban_seq'::regclass);
 K   ALTER TABLE public.nha_xuat_ban ALTER COLUMN ma_nha_xuat_ban DROP DEFAULT;
       public          postgres    false    205    204    205            ^           2604    58431    nhan_vien ma_nhan_vien    DEFAULT     �   ALTER TABLE ONLY public.nhan_vien ALTER COLUMN ma_nhan_vien SET DEFAULT nextval('public.nhan_vien_ma_nhan_vien_seq'::regclass);
 E   ALTER TABLE public.nhan_vien ALTER COLUMN ma_nhan_vien DROP DEFAULT;
       public          postgres    false    211    210    211            _           2604    58447    sach ma_sach    DEFAULT     l   ALTER TABLE ONLY public.sach ALTER COLUMN ma_sach SET DEFAULT nextval('public.sach_ma_sach_seq'::regclass);
 ;   ALTER TABLE public.sach ALTER COLUMN ma_sach DROP DEFAULT;
       public          postgres    false    212    213    213            Z           2604    58380    tac_gia ma_tac_gia    DEFAULT     x   ALTER TABLE ONLY public.tac_gia ALTER COLUMN ma_tac_gia SET DEFAULT nextval('public.tac_gia_ma_tac_gia_seq'::regclass);
 A   ALTER TABLE public.tac_gia ALTER COLUMN ma_tac_gia DROP DEFAULT;
       public          postgres    false    203    202    203            \           2604    58404    tai_khoan ma_tai_khoan    DEFAULT     �   ALTER TABLE ONLY public.tai_khoan ALTER COLUMN ma_tai_khoan SET DEFAULT nextval('public.tai_khoan_ma_tai_khoan_seq'::regclass);
 E   ALTER TABLE public.tai_khoan ALTER COLUMN ma_tai_khoan DROP DEFAULT;
       public          postgres    false    206    207    207            Y           2604    58369    the_loai ma_the_loai    DEFAULT     |   ALTER TABLE ONLY public.the_loai ALTER COLUMN ma_the_loai SET DEFAULT nextval('public.the_loai_ma_the_loai_seq'::regclass);
 C   ALTER TABLE public.the_loai ALTER COLUMN ma_the_loai DROP DEFAULT;
       public          postgres    false    200    201    201                      0    58488    chi_tiet_hoa_don 
   TABLE DATA           i   COPY public.chi_tiet_hoa_don (ma_chitiet_hoa_don, ma_hoa_don, ma_sach, so_luong, thanh_tien) FROM stdin;
    public          postgres    false    217   Q\                 0    58470    hoa_don 
   TABLE DATA           \   COPY public.hoa_don (ma_hoa_don, ma_khach_hang, ma_nhan_vien, ngay_lap_hoa_don) FROM stdin;
    public          postgres    false    215   {\                 0    58412 
   khach_hang 
   TABLE DATA           i   COPY public.khach_hang (ma_khach_hang, ten_khach_hang, so_dien_thoai, dia_chi, ma_tai_khoan) FROM stdin;
    public          postgres    false    209   �\                 0    58390    nha_xuat_ban 
   TABLE DATA           Y   COPY public.nha_xuat_ban (ma_nha_xuat_ban, ten_nha_xuat_ban, dia_chi, email) FROM stdin;
    public          postgres    false    205   ]       
          0    58428 	   nhan_vien 
   TABLE DATA           f   COPY public.nhan_vien (ma_nhan_vien, ten_nhan_vien, so_dien_thoai, dia_chi, ma_tai_khoan) FROM stdin;
    public          postgres    false    211   �]                 0    58444    sach 
   TABLE DATA              COPY public.sach (ma_sach, ten_sach, ma_tac_gia, ma_nha_xuat_ban, ma_the_loai, gia_ban, so_luong, mo_ta, hinh_anh) FROM stdin;
    public          postgres    false    213   ^                 0    58377    tac_gia 
   TABLE DATA           C   COPY public.tac_gia (ma_tac_gia, ten_tac_gia, tieu_su) FROM stdin;
    public          postgres    false    203   xc                 0    58401 	   tai_khoan 
   TABLE DATA           m   COPY public.tai_khoan (ma_tai_khoan, ten_tai_khoan, email, mat_khau, phan_quyen, ten_nguoi_dung) FROM stdin;
    public          postgres    false    207   )e                  0    58366    the_loai 
   TABLE DATA           D   COPY public.the_loai (ma_the_loai, ten_the_loai, mo_ta) FROM stdin;
    public          postgres    false    201   �e                   0    0 '   chi_tiet_hoa_don_ma_chitiet_hoa_don_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public.chi_tiet_hoa_don_ma_chitiet_hoa_don_seq', 2, true);
          public          postgres    false    216            !           0    0    hoa_don_ma_hoa_don_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.hoa_don_ma_hoa_don_seq', 1, true);
          public          postgres    false    214            "           0    0    khach_hang_ma_khach_hang_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.khach_hang_ma_khach_hang_seq', 2, true);
          public          postgres    false    208            #           0    0     nha_xuat_ban_ma_nha_xuat_ban_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.nha_xuat_ban_ma_nha_xuat_ban_seq', 11, true);
          public          postgres    false    204            $           0    0    nhan_vien_ma_nhan_vien_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.nhan_vien_ma_nhan_vien_seq', 2, true);
          public          postgres    false    210            %           0    0    sach_ma_sach_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.sach_ma_sach_seq', 56, true);
          public          postgres    false    212            &           0    0    tac_gia_ma_tac_gia_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.tac_gia_ma_tac_gia_seq', 31, true);
          public          postgres    false    202            '           0    0    tai_khoan_ma_tai_khoan_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.tai_khoan_ma_tai_khoan_seq', 5, true);
          public          postgres    false    206            (           0    0    the_loai_ma_the_loai_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.the_loai_ma_the_loai_seq', 5, true);
          public          postgres    false    200            s           2606    58493 &   chi_tiet_hoa_don chi_tiet_hoa_don_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY public.chi_tiet_hoa_don
    ADD CONSTRAINT chi_tiet_hoa_don_pkey PRIMARY KEY (ma_chitiet_hoa_don);
 P   ALTER TABLE ONLY public.chi_tiet_hoa_don DROP CONSTRAINT chi_tiet_hoa_don_pkey;
       public            postgres    false    217            q           2606    58475    hoa_don hoa_don_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.hoa_don
    ADD CONSTRAINT hoa_don_pkey PRIMARY KEY (ma_hoa_don);
 >   ALTER TABLE ONLY public.hoa_don DROP CONSTRAINT hoa_don_pkey;
       public            postgres    false    215            k           2606    58420    khach_hang khach_hang_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.khach_hang
    ADD CONSTRAINT khach_hang_pkey PRIMARY KEY (ma_khach_hang);
 D   ALTER TABLE ONLY public.khach_hang DROP CONSTRAINT khach_hang_pkey;
       public            postgres    false    209            g           2606    58398    nha_xuat_ban nha_xuat_ban_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.nha_xuat_ban
    ADD CONSTRAINT nha_xuat_ban_pkey PRIMARY KEY (ma_nha_xuat_ban);
 H   ALTER TABLE ONLY public.nha_xuat_ban DROP CONSTRAINT nha_xuat_ban_pkey;
       public            postgres    false    205            m           2606    58436    nhan_vien nhan_vien_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.nhan_vien
    ADD CONSTRAINT nhan_vien_pkey PRIMARY KEY (ma_nhan_vien);
 B   ALTER TABLE ONLY public.nhan_vien DROP CONSTRAINT nhan_vien_pkey;
       public            postgres    false    211            o           2606    58452    sach sach_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.sach
    ADD CONSTRAINT sach_pkey PRIMARY KEY (ma_sach);
 8   ALTER TABLE ONLY public.sach DROP CONSTRAINT sach_pkey;
       public            postgres    false    213            e           2606    58385    tac_gia tac_gia_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tac_gia
    ADD CONSTRAINT tac_gia_pkey PRIMARY KEY (ma_tac_gia);
 >   ALTER TABLE ONLY public.tac_gia DROP CONSTRAINT tac_gia_pkey;
       public            postgres    false    203            i           2606    58409    tai_khoan tai_khoan_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tai_khoan
    ADD CONSTRAINT tai_khoan_pkey PRIMARY KEY (ma_tai_khoan);
 B   ALTER TABLE ONLY public.tai_khoan DROP CONSTRAINT tai_khoan_pkey;
       public            postgres    false    207            c           2606    58374    the_loai the_loai_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.the_loai
    ADD CONSTRAINT the_loai_pkey PRIMARY KEY (ma_the_loai);
 @   ALTER TABLE ONLY public.the_loai DROP CONSTRAINT the_loai_pkey;
       public            postgres    false    201            {           2606    58494 1   chi_tiet_hoa_don chi_tiet_hoa_don_ma_hoa_don_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.chi_tiet_hoa_don
    ADD CONSTRAINT chi_tiet_hoa_don_ma_hoa_don_fkey FOREIGN KEY (ma_hoa_don) REFERENCES public.hoa_don(ma_hoa_don);
 [   ALTER TABLE ONLY public.chi_tiet_hoa_don DROP CONSTRAINT chi_tiet_hoa_don_ma_hoa_don_fkey;
       public          postgres    false    217    215    2929            |           2606    58499 .   chi_tiet_hoa_don chi_tiet_hoa_don_ma_sach_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.chi_tiet_hoa_don
    ADD CONSTRAINT chi_tiet_hoa_don_ma_sach_fkey FOREIGN KEY (ma_sach) REFERENCES public.sach(ma_sach);
 X   ALTER TABLE ONLY public.chi_tiet_hoa_don DROP CONSTRAINT chi_tiet_hoa_don_ma_sach_fkey;
       public          postgres    false    2927    213    217            y           2606    58476 "   hoa_don hoa_don_ma_khach_hang_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.hoa_don
    ADD CONSTRAINT hoa_don_ma_khach_hang_fkey FOREIGN KEY (ma_khach_hang) REFERENCES public.khach_hang(ma_khach_hang);
 L   ALTER TABLE ONLY public.hoa_don DROP CONSTRAINT hoa_don_ma_khach_hang_fkey;
       public          postgres    false    209    215    2923            z           2606    58481 !   hoa_don hoa_don_ma_nhan_vien_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.hoa_don
    ADD CONSTRAINT hoa_don_ma_nhan_vien_fkey FOREIGN KEY (ma_nhan_vien) REFERENCES public.nhan_vien(ma_nhan_vien);
 K   ALTER TABLE ONLY public.hoa_don DROP CONSTRAINT hoa_don_ma_nhan_vien_fkey;
       public          postgres    false    215    211    2925            t           2606    58421 '   khach_hang khach_hang_ma_tai_khoan_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.khach_hang
    ADD CONSTRAINT khach_hang_ma_tai_khoan_fkey FOREIGN KEY (ma_tai_khoan) REFERENCES public.tai_khoan(ma_tai_khoan);
 Q   ALTER TABLE ONLY public.khach_hang DROP CONSTRAINT khach_hang_ma_tai_khoan_fkey;
       public          postgres    false    207    209    2921            u           2606    58437 %   nhan_vien nhan_vien_ma_tai_khoan_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.nhan_vien
    ADD CONSTRAINT nhan_vien_ma_tai_khoan_fkey FOREIGN KEY (ma_tai_khoan) REFERENCES public.tai_khoan(ma_tai_khoan);
 O   ALTER TABLE ONLY public.nhan_vien DROP CONSTRAINT nhan_vien_ma_tai_khoan_fkey;
       public          postgres    false    2921    207    211            w           2606    58458    sach sach_ma_nha_xuat_ban_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.sach
    ADD CONSTRAINT sach_ma_nha_xuat_ban_fkey FOREIGN KEY (ma_nha_xuat_ban) REFERENCES public.nha_xuat_ban(ma_nha_xuat_ban);
 H   ALTER TABLE ONLY public.sach DROP CONSTRAINT sach_ma_nha_xuat_ban_fkey;
       public          postgres    false    205    2919    213            v           2606    58453    sach sach_ma_tac_gia_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.sach
    ADD CONSTRAINT sach_ma_tac_gia_fkey FOREIGN KEY (ma_tac_gia) REFERENCES public.tac_gia(ma_tac_gia);
 C   ALTER TABLE ONLY public.sach DROP CONSTRAINT sach_ma_tac_gia_fkey;
       public          postgres    false    213    2917    203            x           2606    58463    sach sach_ma_the_loai_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.sach
    ADD CONSTRAINT sach_ma_the_loai_fkey FOREIGN KEY (ma_the_loai) REFERENCES public.the_loai(ma_the_loai);
 D   ALTER TABLE ONLY public.sach DROP CONSTRAINT sach_ma_the_loai_fkey;
       public          postgres    false    201    213    2915                  x�3�4�42&�z\1z\\\ ��         "   x�3�4B##S]S]CS+0����� P�         H   x�3��8��R�'����RNC#cS3�#�� �[X���e��sx��pw��#�1��=... cq�         �   x�3��pRy�{j^����݋8C@��
���*�f�ep��q�Յi�I�&cWe1��������$�+��p�̼t��L��\/�vx-vEf`EG&x(x^���Į�
��wOLkŮ����b�̇�ggbWgA�:C���S3��������� ���B      
   K   x�3��8��R�'����RNC#cS3�#�� �[X���e��sx��pw�B�����@`�Jc���� � �         Q  x��VOoG=O>Ŝ��@�];�#Uc�l��r�2,fwJv�8;Pߠ8 $P�N"�m%\�m�a�|����f�v�Seə�g���y�7�6XO�3�7��)�G��侌��0�՘Sw���r����O���>���ٛ��득��e����	���?å�ü��c��H~�J���9�:s�+sl/*�G���.�*����C@��	A{�NdG�(,��ڑ,�__���.�&�_UȜ��o���oٛ���n�� :����40loTH@(�j������n�*��c�l������iDz\d��D,��wM���
霅Za�t��xW
��;ɽ9dχ̭�&[rc���'<8���Pd�K'�֣D�`hyUx�}�7N�Z����T��F#1��怭ٚ�]<B����҂6���w���U�S[�~����O1N����O�sJ"B���OT�\�P:$��?B���}���C�Y���ש�>(�򌎍��V���F��BaE��" �[�|�|Ͽ�I�k���nխ}�\�"��-�x��hn����HV�6�RM�=Fc �z	��+�����YUD��)�l��o�	fW1�|Z�y�	LI��BF������U6ǿ�Tr�It�Ln��EnP�S]@�q��b�w��` d���]�~( WL3>��v�=?2c�L֣�3%���b�w�O~Q�mZF�u�,f��ALM��R��=-ґ-m�ƚ ȏ%����WP`d�s��К�{���%��&��5�gʗ���ӸK3�t<趠"&��N�8=R�0���+i���%��5���4���}�2���+T�O:�R��Y��.�LӍ��Ev�;�D�����hC#0�x�n�TSJDաA��u,O��OƘ�Ϩ�c��Y)� �{���Bw/!X�q��J�֢��}�(�SF�e��z�c�H((�H���+�>'�]2g��~��\���I��u�wG�c~[�����*�H8��x(���]B?��Ї}X�d�R-w�!�ەD:\�w1�!�c��������t���w[��鑕�/0l��";�*AYp��A�W[�Ő{��E��:t4������H<\�z�]�1����-��t �lG	0	��P�?- �l��*��⎘�b8n�V�ݿG�腎U������h�e�k4;�D�{���A�������1G�<��B�P^��VH� C�I��e�@M��Y^v���bs��Wƶ�e��mm'i٬U�7`j���X������Q�XX��۩i=JUd ��"mW�8Ps�E�.��K��P��`;e�Fm����}�G�HE�`�(�Α��D0�w�����Jz�         �  x�E�Mn�@���)x#R��e`/���8(P �f4�3�����uQ�mE��^��=t�rFH��7�G��T1��.4�M>H��~�7�ܞ9�KS+k(/�����;���8��|t"e+���#oˀ&�,fڨPM!�� �K�x����j��%��)��4cN�ҥJ� /�Cw�b0W����s/�$�1����>�T���s�K��M��u/u׊�����˷~b2�%�ʊ���ho�o1��Y�1�#��f˕�	$X�(�ċ��M�>��v�	��QLf�$ה��QI���r��[ICW1��L"ٳ�.�	\�kC^�j����SXs�����&����U��(ԟ�8=���?eJw����"�����[:�!�����)l��k&ׯ8���K"ɨ��
�f8�zd��         f   x�3�tL������L-�031tH�M���K���4426�Lˆd�V*��p�ToTmZL8C���ҁ�q���V��Ad����L�F�	�,V�`Sc���� ��9          i   x�3��8��D��(����<�����)�d^����e�rxQ�B�� �1����;�4�+?�=1/$l�Q�x��7�7�����P(y�k?����� �(�     