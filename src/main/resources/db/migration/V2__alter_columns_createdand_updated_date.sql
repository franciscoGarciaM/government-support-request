ALTER TABLE public.service_status ALTER COLUMN created_date SET DEFAULT CURRENT_DATE;
ALTER TABLE public.service_status ALTER COLUMN updated_date SET DEFAULT CURRENT_DATE;
ALTER TABLE public.service_status ALTER COLUMN active SET DEFAULT true;