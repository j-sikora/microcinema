package com.microcinema.cinemareporttask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
@Slf4j
public class CinemaReportTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaReportTaskApplication.class, args);
    }

    @Bean
    public CommandLineRunner taskRunner() {
        return new CinemaReportTaskRunner();
    }

    public class CinemaReportTaskRunner implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            if(args != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    stringBuilder.append(i > 0 ? "," : "")
                            .append(i)
                            .append(":")
                            .append(args[i]);
                }
                log.info(stringBuilder.toString());
            }
        }
    }

}
