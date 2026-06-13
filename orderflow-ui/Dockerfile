# Build stage – use full Node 20 (not slim) to ensure build tools are present
FROM node:20 AS build
WORKDIR /app

# Copy package files
COPY package*.json ./

# Remove any existing lock file and node_modules to start fresh
RUN rm -rf node_modules package-lock.json

# Install dependencies including optional ones
RUN npm install --include=optional

# Copy source code
COPY . .

# Build the app
RUN npm run build

# Production stage (nginx alpine remains lightweight)
FROM nginx:stable-alpine
COPY --from=build /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]